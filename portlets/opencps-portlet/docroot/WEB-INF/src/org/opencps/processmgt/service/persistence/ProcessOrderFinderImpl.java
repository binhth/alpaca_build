/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.processmgt.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.opencps.dossiermgt.bean.ProcessOrderBean;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.impl.DossierImpl;
import org.opencps.processmgt.model.ProcessOrder;
import org.opencps.processmgt.model.impl.ProcessOrderImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * @author trungnt
 */
/**
 * @author trungnt
 *
 */
public class ProcessOrderFinderImpl extends BasePersistenceImpl<ProcessOrder>
    implements ProcessOrderFinder {

	public final static String SQL_PROCESS_ORDER_FINDER =
					ProcessOrderFinder.class
	        .getName() + ".searchProcessOrder";
	public final static String SQL_PROCESS_ORDER_COUNT =
					ProcessOrderFinder.class
	        .getName() + ".countProcessOrder";
	
	public final static String SQL_USER_PROCESS_STEP =
					ProcessOrderFinder.class
	        .getName() + ".getUserProcessStep";

	public final static String SQL_ONEGATE_PROCESS_ORDER_FINDER =
			ProcessOrderFinder.class
			.getName() + ".oneGateSearchProcessOrder";
	public final static String SQL_ONEGATE_PROCESS_ORDER_COUNT =
			ProcessOrderFinder.class
			.getName() + ".oneGateCountProcessOrder";
	
	public int countProcessOrder(long processStepId, long loginUserId, long actionUserId) {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil
			    .get(SQL_PROCESS_ORDER_COUNT);

			if (processStepId <= 0) {
				sql = StringUtil
				    .replace(
				        sql, "AND opencps_processstep.processStepId = ?",
				        StringPool.BLANK);
			}

			SQLQuery q = session
			    .createSQLQuery(sql);
			q
			    .setCacheable(false);

			q
			    .addScalar(COUNT_COLUMN_NAME, Type.INTEGER);

			QueryPos qPos = QueryPos
			    .getInstance(q);

			if (processStepId > 0) {
				qPos
				    .add(processStepId);
			}

			qPos
			    .add(loginUserId);
			qPos
			    .add(actionUserId);

			Iterator<Integer> itr = q
			    .iterate();

			if (itr
			    .hasNext()) {
				Integer count = itr
				    .next();

				if (count != null) {
					return count
					    .intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			_log
			    .error(e);
		}
		finally {
			closeSession(session);
		}

		return 0;

	}
	
	public List searchProcessOrder(

	    long processStepId, long loginUserId, long actionUserId, int start, int end,
	    OrderByComparator orderByComparator) {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil
			    .get(SQL_PROCESS_ORDER_FINDER);

			if (processStepId <= 0) {
				sql = StringUtil
				    .replace(
				        sql, "AND opencps_processstep.processStepId = ?",
				        StringPool.BLANK);
			}

			SQLQuery q = session
			    .createSQLQuery(sql);

			q
			    .setCacheable(false);

			q
			    .addEntity("ProcessOrder", ProcessOrderImpl.class);

			q
			    .addScalar("serviceConfigId", Type.LONG);
			q
			    .addScalar("subjectId", Type.STRING);
			q
			    .addScalar("subjectName", Type.STRING);
			q
			    .addScalar("receptionNo", Type.STRING);
			q
			    .addScalar("serviceName", Type.STRING);
			q
			    .addScalar("stepName", Type.STRING);
			q
			    .addScalar("sequenceNo", Type.STRING);
			q
			    .addScalar("daysDuration", Type.INTEGER);
			q
			    .addScalar("referenceDossierPartId", Type.LONG);

			QueryPos qPos = QueryPos
			    .getInstance(q);

			if (processStepId > 0) {
				qPos
				    .add(processStepId);
			}

			qPos
			    .add(loginUserId);
			qPos
			    .add(actionUserId);

			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil
			    .list(q, getDialect(), start, end).iterator();

			List<ProcessOrderBean> processOrderBeans =
			    new ArrayList<ProcessOrderBean>();

			if (itr
			    .hasNext()) {
				while (itr
				    .hasNext()) {
					ProcessOrderBean processOrderBean = new ProcessOrderBean();

					Object[] objects = itr
					    .next();

					ProcessOrder processOrder = (ProcessOrder) objects[0];

					long serviceConfigId = GetterUtil
					    .getLong(objects[1]);
					String subjectId = (String) objects[2];
					String subjectName = (String) objects[3];
					String receptionNo = (String) objects[4];
					String serviceName = (String) objects[5];
					String stepName = (String) objects[6];
					String sequenceNo = (String) objects[7];
					int daysDuration = GetterUtil
					    .getInteger(objects[8]);
					long referenceDossierPartId = GetterUtil
					    .getLong(objects[9]);

					processOrderBean
					    .setActionDatetime(processOrder
					        .getActionDatetime());
					processOrderBean
					    .setActionUserId(processOrder
					        .getActionUserId());
					processOrderBean
					    .setAssignToUserId(processOrder
					        .getAssignToUserId());
					// processOrderBean.setAssignToUserName(assignToUserName);
					processOrderBean
					    .setCompanyId(processOrder
					        .getCompanyId());
					processOrderBean
					    .setDaysDuration(daysDuration);
					// processOrderBean.setDealine(dealine);
					processOrderBean
					    .setDossierId(processOrder
					        .getDossierId());
					processOrderBean
					    .setDossierStatus(processOrder
					        .getDossierStatus());
					processOrderBean
					    .setDossierTemplateId(processOrder
					        .getDossierTemplateId());
					processOrderBean
					    .setFileGroupId(processOrder
					        .getFileGroupId());
					processOrderBean
					    .setGovAgencyCode(processOrder
					        .getGovAgencyCode());
					processOrderBean
					    .setGovAgencyName(processOrder
					        .getGovAgencyName());
					processOrderBean
					    .setGovAgencyOrganizationId(processOrder
					        .getGovAgencyOrganizationId());
					processOrderBean
					    .setGroupId(processOrder
					        .getGroupId());
					processOrderBean
					    .setProcessOrderId(processOrder
					        .getProcessOrderId());
					processOrderBean
					    .setProcessStepId(processStepId);
					processOrderBean
					    .setReceptionNo(receptionNo);
					processOrderBean
					    .setReferenceDossierPartId(referenceDossierPartId);
					processOrderBean
					    .setSequenceNo(sequenceNo);
					processOrderBean
					    .setServiceConfigId(serviceConfigId);
					processOrderBean
					    .setServiceInfoId(processOrder
					        .getServiceInfoId());
					processOrderBean
					    .setServiceName(serviceName);
					processOrderBean
					    .setServiceProcessId(processOrder
					        .getServiceProcessId());
					processOrderBean
					    .setStepName(stepName);
					processOrderBean
					    .setSubjectId(subjectId);
					processOrderBean
					    .setSubjectName(subjectName);
					processOrderBean
					    .setUserId(processOrder
					        .getUserId());

					processOrderBeans
					    .add(processOrderBean);
				}
			}

			return processOrderBeans;
		}
		catch (Exception e) {
			_log
			    .error(e);
		}
		finally {
			closeSession(session);
		}

		return null;

	}
	
	
	/**
	 * @param longinUserId
	 * @return
	 */
	public List getUserProcessStep(

	    long longinUserId) {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil
			    .get(SQL_USER_PROCESS_STEP);

			SQLQuery q = session
			    .createSQLQuery(sql);

			q
			    .setCacheable(false);

			q
			    .addScalar("processStepId", Type.LONG);
			q
			    .addScalar("stepName", Type.STRING);

			QueryPos qPos = QueryPos
			    .getInstance(q);

			qPos
			    .add(longinUserId);
			qPos
			    .add(longinUserId);

			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil
			    .list(
			        q, getDialect(), QueryUtil.ALL_POS,
			        QueryUtil.ALL_POS).iterator();

			List<ProcessOrderBean> processOrderBeans =
			    new ArrayList<ProcessOrderBean>();

			if (itr
			    .hasNext()) {
				while (itr
				    .hasNext()) {
					ProcessOrderBean processOrderBean = new ProcessOrderBean();

					Object[] objects = itr
					    .next();

					long processStepId = GetterUtil
					    .getLong(objects[0]);
					String processStepName = (String) objects[1];

					processOrderBean
					    .setProcessStepId(processStepId);
					processOrderBean
					    .setStepName(processStepName);

					processOrderBeans
					    .add(processOrderBean);
				}
			}

			return processOrderBeans;
		}
		catch (Exception e) {
			_log
			    .error(e);
		}
		finally {
			closeSession(session);
		}

		return null;
	}

	public int oneGateCountProcessOrder(long groupId, String keyword, int dossierStatus, long serviceInfoId, long processStepId) {

		String[] keywords = null;

		boolean andOperator = false;

		if (Validator
		    .isNotNull(keyword)) {
			keywords = CustomSQLUtil
			    .keywords(keyword);
		}
		else {
			andOperator = true;
		}

		return oneGateCountProcessOrder(groupId, keywords, dossierStatus, serviceInfoId, processStepId, andOperator);
	}

	private int oneGateCountProcessOrder(
	    long groupId, String[] keywords, int dossierStatus, long serviceInfoId, long processStepId,
	    boolean andOperator) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil
			    .get(SQL_ONEGATE_PROCESS_ORDER_COUNT);

			if (keywords != null && keywords.length > 0) {
				sql = CustomSQLUtil
				    .replaceKeywords(
				        sql, "lower(opencps_processorder.govAgencyName)",
				        StringPool.LIKE, true, keywords);

				sql = CustomSQLUtil
				    .replaceKeywords(
				        sql, "lower(opencps_dossier.subjectName)",
				        StringPool.LIKE, true, keywords);
				sql = CustomSQLUtil
					    .replaceKeywords(
					        sql, "lower(opencps_dossier.receptionNo)",
					        StringPool.LIKE, true, keywords);
			}

			

			if (keywords == null || keywords.length == 0) {
				sql = StringUtil
					    .replace(
					        sql,
					        "AND ((lower(opencps_processorder.govAgencyName) LIKE ? [$AND_OR_NULL_CHECK$]) OR (lower(opencps_dossier.subjectName) LIKE ? [$AND_OR_NULL_CHECK$]) OR (lower(opencps_dossier.receptionNo) LIKE ? [$AND_OR_NULL_CHECK$]))",
					        StringPool.BLANK);
			}

			if (dossierStatus < 0) {
				sql = StringUtil
				    .replace(
				        sql, "AND opencps_processorder.dossierStatus = ?",
				        StringPool.BLANK);
			}
			if (serviceInfoId < 0) {
				sql = StringUtil
					    .replace(
					        sql, "AND opencps_processorder.serviceInfoId = ?",
					        StringPool.BLANK);				
			}
			
			sql = CustomSQLUtil
						    .replaceAndOperator(sql, andOperator);

			SQLQuery q = session
			    .createSQLQuery(sql);

			q
			    .addScalar(COUNT_COLUMN_NAME, Type.INTEGER);

			QueryPos qPos = QueryPos
			    .getInstance(q);

			//qPos.add(groupId);
			qPos.add(processStepId);
			
			if (dossierStatus >= 0) {
				qPos
				    .add(dossierStatus);
			}
			if (serviceInfoId >= 0) {
				qPos
					.add(serviceInfoId);
			}

			if (keywords != null && keywords.length > 0) {
				qPos
				    .add(keywords, 2);
				qPos
				    .add(keywords, 2);
				qPos
					.add(keywords, 2);
			}

			Iterator<Integer> itr = q
			    .iterate();

			if (itr
			    .hasNext()) {
				Integer count = itr
				    .next();

				if (count != null) {
					return count
					    .intValue();
				}
			}

			return 0;

		}
		catch (Exception e) {
			_log
			    .error(e);
		}
		finally {
			closeSession(session);
		}

		return 0;
	}

	public List<ProcessOrder> oneGateSearchProcessOrder(
	    long groupId, String keyword, int dossierStatus, long serviceInfoId, long processStepId, int start, int end,
	    OrderByComparator obc) {

		String[] keywords = null;
		boolean andOperator = false;
		if (Validator
		    .isNotNull(keyword)) {
			keywords = CustomSQLUtil
			    .keywords(keyword);
		}
		else {
			andOperator = true;
		}
		return oneGateSearchProcessOrder(
		    groupId, keywords, dossierStatus, serviceInfoId, processStepId, andOperator, start, end, obc);
	}

	private List<ProcessOrder> oneGateSearchProcessOrder(
	    long groupId, String[] keywords, int dossierStatus, long serviceInfoId, long processStepId, boolean andOperator,
	    int start, int end, OrderByComparator obc) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil
			    .get(SQL_ONEGATE_PROCESS_ORDER_FINDER);

			if (keywords != null && keywords.length > 0) {
				sql = CustomSQLUtil
					    .replaceKeywords(
					        sql, "lower(opencps_processorder.govAgencyName)",
					        StringPool.LIKE, true, keywords);

					sql = CustomSQLUtil
					    .replaceKeywords(
					        sql, "lower(opencps_dossier.subjectName)",
					        StringPool.LIKE, true, keywords);
					sql = CustomSQLUtil
						    .replaceKeywords(
						        sql, "lower(opencps_dossier.receptionNo)",
						        StringPool.LIKE, true, keywords);
			}

			if (keywords == null || keywords.length == 0) {
				sql = StringUtil
					    .replace(
					        sql,
					        "AND ((lower(opencps_processorder.govAgencyName) LIKE ? [$AND_OR_NULL_CHECK$]) OR (lower(opencps_dossier.subjectName) LIKE ? [$AND_OR_NULL_CHECK$]) OR (lower(opencps_dossier.receptionNo) LIKE ? [$AND_OR_NULL_CHECK$]))",
					        StringPool.BLANK);
			}

			if (dossierStatus < 0) {
				sql = StringUtil
				    .replace(
				        sql, "AND opencps_dossier.dossierStatus = ?",
				        StringPool.BLANK);
			}
			if (serviceInfoId < 0) {
				sql = StringUtil
					    .replace(
					        sql, "AND opencps_processorder.serviceInfoId = ?",
					        StringPool.BLANK);				
			}
			
			sql = CustomSQLUtil
						    .replaceAndOperator(sql, andOperator);

			SQLQuery q = session
			    .createSQLQuery(sql);

			q
			    .addEntity("ProcessOrder", ProcessOrderImpl.class);

			QueryPos qPos = QueryPos
			    .getInstance(q);

			//qPos.add(groupId);
			qPos.add(processStepId);
			
			if (dossierStatus >= 0) {
				qPos
				    .add(dossierStatus);
			}
			if (serviceInfoId >= 0) {
				qPos
					.add(serviceInfoId);
			}
			
			if (keywords != null && keywords.length > 0) {
				qPos
				    .add(keywords, 2);
				qPos
				    .add(keywords, 2);
				qPos
					.add(keywords, 2);
			}

			return (List<ProcessOrder>) QueryUtil
			    .list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			_log
			    .error(e);
		}
		finally {
			closeSession(session);
		}

		return null;
	}
	
	private Log _log = LogFactoryUtil.getLog(ProcessOrderFinderImpl.class.getName());
}
