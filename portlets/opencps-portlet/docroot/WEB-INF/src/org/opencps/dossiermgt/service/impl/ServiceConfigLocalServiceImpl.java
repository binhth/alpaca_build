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

package org.opencps.dossiermgt.service.impl;

import java.util.Date;
import java.util.List;

import org.opencps.dossiermgt.NoSuchServiceConfigException;
import org.opencps.dossiermgt.model.ServiceConfig;
import org.opencps.dossiermgt.service.base.ServiceConfigLocalServiceBaseImpl;
import org.opencps.servicemgt.model.ServiceInfo;
import org.opencps.servicemgt.service.ServiceInfoLocalServiceUtil;
import org.opencps.usermgt.model.WorkingUnit;
import org.opencps.usermgt.service.WorkingUnitLocalServiceUtil;
import org.opencps.util.PortletConstants;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
/**
 * The implementation of the service config local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link org.opencps.dossiermgt.service.ServiceConfigLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author trungnt
 * @see org.opencps.dossiermgt.service.base.ServiceConfigLocalServiceBaseImpl
 * @see org.opencps.dossiermgt.service.ServiceConfigLocalServiceUtil
 */
public class ServiceConfigLocalServiceImpl
    extends ServiceConfigLocalServiceBaseImpl {

	public ServiceConfig addServiceConfig(
	    long serviceInfoId, String serviceAdministrationIndex,
	    String serviceDomainIndex, long dossierTemplateId, String govAgencyCode,
	    String govAgencyName, int serviceLevel, String domainCode, long userId,
	    String serviceInstruction, boolean servicePortal,
	    boolean serviceOnegate, boolean serviceBackoffice, boolean serviceCitizen,
	    boolean serviceBusinees, ServiceContext serviceContext)
	    throws PortalException, SystemException {

		ServiceInfo serviceInfo = ServiceInfoLocalServiceUtil
		    .getServiceInfo(serviceInfoId);

		WorkingUnit workingUnit = null;

		long serviceConfigId = CounterLocalServiceUtil
		    .increment(ServiceConfig.class
		        .getName());

		ServiceConfig serviceConfig = serviceConfigPersistence
		    .create(serviceConfigId);

		boolean isBackOffice = false;

		if (serviceBackoffice) {
			workingUnit = WorkingUnitLocalServiceUtil
			    .getWorkingUnit(serviceInfo
			        .getGroupId(), govAgencyCode);
			if (workingUnit != null) {
				isBackOffice = true;
			}
		}

		Date currentDate = new Date();

		serviceConfig
		    .setUserId(userId);
		serviceConfig
		    .setCompanyId(serviceContext
		        .getCompanyId());
		serviceConfig
		    .setGroupId(serviceContext
		        .getScopeGroupId());
		serviceConfig
		    .setCreateDate(currentDate);
		serviceConfig
		    .setModifiedDate(currentDate);

		serviceConfig.setServiceInstruction(serviceInstruction);
		serviceConfig.setServicePortal(servicePortal);
		serviceConfig.setServiceOnegate(serviceOnegate);
		serviceConfig.setServiceBackoffice(serviceBackoffice);
		serviceConfig.setServiceCitizen(serviceCitizen);
		serviceConfig.setServiceBusinees(serviceBusinees);
		serviceConfig
		    .setServiceInfoId(serviceInfoId);
		serviceConfig
		    .setServiceAdministrationIndex(serviceAdministrationIndex);
		serviceConfig
		    .setServiceDomainIndex(serviceDomainIndex);
		serviceConfig
		    .setDomainCode(domainCode);
		serviceConfig
		    .setDossierTemplateId(dossierTemplateId);
		serviceConfig
		    .setGovAgencyCode(govAgencyCode);
		serviceConfig
		    .setGovAgencyName(govAgencyName);
		serviceConfig
		    .setServiceLevel(serviceLevel);;
		if (isBackOffice) {
			serviceConfig
			    .setGovAgencyOrganizationId(workingUnit
			        .getMappingOrganisationId());
		}

		return serviceConfigPersistence
		    .update(serviceConfig);

	}

	public int countAll()
	    throws SystemException {

		return serviceConfigPersistence
		    .countAll();
	}

	public int countByDossierTemplateId(long dossierTemplateId)
	    throws SystemException {

		return serviceConfigPersistence
		    .countByDossierTemplateId(dossierTemplateId);
	}

	public int countServiceConfig(
	    long groupId, String keywords, String govAgencyCode,
	    String domainCode) {

		return serviceConfigFinder
		    .countServiceConfig(groupId, keywords, govAgencyCode, domainCode);
	}

	public int countServiceConfigByServiceMode(
	    long groupId, int[] serviceModes) {

		return serviceConfigFinder
		    .countServiceConfigByServiceMode(groupId, serviceModes);
	}

	public int countServiceConFigsByG_M(long groupId, int serviceMode)
	    throws SystemException {

		return serviceConfigPersistence
		    .countByG_M(groupId, serviceMode);
	}

	public void deleteServiceConfigById(long serviceConfigId)
	    throws NoSuchServiceConfigException, SystemException {

		serviceConfigPersistence
		    .remove(serviceConfigId);
	}

	public List<ServiceConfig> getAll(
	    int start, int end, OrderByComparator orderByComparator)
	    throws SystemException {

		return serviceConfigPersistence
		    .findAll(start, end, orderByComparator);
	}

	public List<ServiceConfig> getServiceConfigs(long dossierTemplateId)
	    throws SystemException {

		return serviceConfigPersistence
		    .findByDossierTemplateId(dossierTemplateId);
	}

	public List<ServiceConfig> getServiceConFigsByG_M(
	    long groupId, int serviceMode, int start, int end)
	    throws SystemException {

		return serviceConfigPersistence
		    .filterFindByG_M(groupId, serviceMode, start, end);
	}

	public List<ServiceConfig> searchServiceConfig(
	    long groupId, String keywords, String govAgencyCode, String domainCode,
	    int start, int end) {

		return serviceConfigFinder
		    .searchServiceConfig(
		        groupId, keywords, govAgencyCode, domainCode, start, end);

	}

	public List<ServiceConfig> searchServiceConfigByServiceMode(
	    long groupId, int[] serviceModes, int start, int end,
	    OrderByComparator orderByComparator) {

		return serviceConfigFinder
		    .searchServiceConfigByServiceMode(
		        groupId, serviceModes, start, end, orderByComparator);

	}

	public ServiceConfig updateServiceConfig(
	    long serviceConfigId, long serviceInfoId, String serviceAdministrationIndex,
	    String serviceDomainIndex, long dossierTemplateId, String govAgencyCode,
	    String govAgencyName, int serviceLevel, String domainCode, long userId,
	    String serviceInstruction, boolean servicePortal,
	    boolean serviceOnegate, boolean serviceBackoffice, boolean serviceCitizen,
	    boolean serviceBusinees, ServiceContext serviceContext)
	    throws PortalException, SystemException {

		ServiceInfo serviceInfo = ServiceInfoLocalServiceUtil
		    .getServiceInfo(serviceInfoId);

		WorkingUnit workingUnit = null;

		ServiceConfig serviceConfig = serviceConfigPersistence
		    .findByPrimaryKey(serviceConfigId);

		boolean isBackOffice = false;

		if (serviceBackoffice) {
			workingUnit = WorkingUnitLocalServiceUtil
			    .getWorkingUnit(serviceInfo
			        .getGroupId(), govAgencyCode);
			if (workingUnit != null) {
				isBackOffice = true;
			}
		}

		Date currentDate = new Date();

		serviceConfig
		    .setUserId(userId);
		serviceConfig
		    .setCompanyId(serviceContext
		        .getCompanyId());
		serviceConfig
		    .setGroupId(serviceContext
		        .getScopeGroupId());
		serviceConfig
		    .setCreateDate(currentDate);
		serviceConfig
		    .setModifiedDate(currentDate);

		serviceConfig.setServiceInstruction(serviceInstruction);
		serviceConfig.setServicePortal(servicePortal);
		serviceConfig.setServiceOnegate(serviceOnegate);
		serviceConfig.setServiceBackoffice(serviceBackoffice);
		serviceConfig.setServiceCitizen(serviceCitizen);
		serviceConfig.setServiceBusinees(serviceBusinees);
		serviceConfig
		    .setServiceInfoId(serviceInfoId);
		serviceConfig
		    .setServiceAdministrationIndex(serviceAdministrationIndex);
		serviceConfig
		    .setServiceDomainIndex(serviceDomainIndex);
		serviceConfig
		    .setDomainCode(domainCode);
		serviceConfig
		    .setDossierTemplateId(dossierTemplateId);
		serviceConfig
		    .setGovAgencyCode(govAgencyCode);
		serviceConfig
		    .setGovAgencyName(govAgencyName);
		serviceConfig
		    .setServiceLevel(serviceLevel);;
		if (isBackOffice) {
			serviceConfig
			    .setGovAgencyOrganizationId(workingUnit
			        .getMappingOrganisationId());
		}

		return serviceConfigPersistence
		    .update(serviceConfig);

	}
	
	public ServiceConfig getServiceConfigByG_S(long groupId, long serviceInfoId) 
					throws NoSuchServiceConfigException, SystemException {
		return serviceConfigPersistence.findByG_S(groupId, serviceInfoId);
	}
}
