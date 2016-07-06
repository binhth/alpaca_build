/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dict.dao.service.persistence;

import com.dict.dao.NoSuchDictCollectionAlpacaJSException;
import com.dict.dao.model.DictCollectionAlpacaJS;
import com.dict.dao.model.impl.DictCollectionAlpacaJSImpl;
import com.dict.dao.model.impl.DictCollectionAlpacaJSModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dict collection alpaca j s service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author binhth
 * @see DictCollectionAlpacaJSPersistence
 * @see DictCollectionAlpacaJSUtil
 * @generated
 */
public class DictCollectionAlpacaJSPersistenceImpl extends BasePersistenceImpl<DictCollectionAlpacaJS>
	implements DictCollectionAlpacaJSPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictCollectionAlpacaJSUtil} to access the dict collection alpaca j s persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictCollectionAlpacaJSImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionAlpacaJSModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionAlpacaJSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionAlpacaJSModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionAlpacaJSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionAlpacaJSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionAlpacaJSModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionAlpacaJSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionAlpacaJSModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionAlpacaJSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			DictCollectionAlpacaJSModelImpl.GROUPID_COLUMN_BITMASK |
			DictCollectionAlpacaJSModelImpl.COLLECTIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionAlpacaJSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dict collection alpaca j ses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dict collection alpaca j ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollectionAlpacaJS> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict collection alpaca j ses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dict.dao.model.impl.DictCollectionAlpacaJSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dict collection alpaca j ses
	 * @param end the upper bound of the range of dict collection alpaca j ses (not inclusive)
	 * @return the range of matching dict collection alpaca j ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollectionAlpacaJS> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict collection alpaca j ses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dict.dao.model.impl.DictCollectionAlpacaJSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dict collection alpaca j ses
	 * @param end the upper bound of the range of dict collection alpaca j ses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict collection alpaca j ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollectionAlpacaJS> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<DictCollectionAlpacaJS> list = (List<DictCollectionAlpacaJS>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictCollectionAlpacaJS dictCollectionAlpacaJS : list) {
				if ((groupId != dictCollectionAlpacaJS.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DICTCOLLECTIONALPACAJS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictCollectionAlpacaJSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<DictCollectionAlpacaJS>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictCollectionAlpacaJS>(list);
				}
				else {
					list = (List<DictCollectionAlpacaJS>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dict collection alpaca j s in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict collection alpaca j s
	 * @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a matching dict collection alpaca j s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDictCollectionAlpacaJSException, SystemException {
		DictCollectionAlpacaJS dictCollectionAlpacaJS = fetchByGroupId_First(groupId,
				orderByComparator);

		if (dictCollectionAlpacaJS != null) {
			return dictCollectionAlpacaJS;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictCollectionAlpacaJSException(msg.toString());
	}

	/**
	 * Returns the first dict collection alpaca j s in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict collection alpaca j s, or <code>null</code> if a matching dict collection alpaca j s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictCollectionAlpacaJS> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict collection alpaca j s in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict collection alpaca j s
	 * @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a matching dict collection alpaca j s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDictCollectionAlpacaJSException, SystemException {
		DictCollectionAlpacaJS dictCollectionAlpacaJS = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (dictCollectionAlpacaJS != null) {
			return dictCollectionAlpacaJS;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictCollectionAlpacaJSException(msg.toString());
	}

	/**
	 * Returns the last dict collection alpaca j s in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict collection alpaca j s, or <code>null</code> if a matching dict collection alpaca j s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DictCollectionAlpacaJS> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict collection alpaca j ses before and after the current dict collection alpaca j s in the ordered set where groupId = &#63;.
	 *
	 * @param dictCollectionId the primary key of the current dict collection alpaca j s
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict collection alpaca j s
	 * @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a dict collection alpaca j s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS[] findByGroupId_PrevAndNext(
		long dictCollectionId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchDictCollectionAlpacaJSException, SystemException {
		DictCollectionAlpacaJS dictCollectionAlpacaJS = findByPrimaryKey(dictCollectionId);

		Session session = null;

		try {
			session = openSession();

			DictCollectionAlpacaJS[] array = new DictCollectionAlpacaJSImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					dictCollectionAlpacaJS, groupId, orderByComparator, true);

			array[1] = dictCollectionAlpacaJS;

			array[2] = getByGroupId_PrevAndNext(session,
					dictCollectionAlpacaJS, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictCollectionAlpacaJS getByGroupId_PrevAndNext(Session session,
		DictCollectionAlpacaJS dictCollectionAlpacaJS, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTCOLLECTIONALPACAJS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DictCollectionAlpacaJSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictCollectionAlpacaJS);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictCollectionAlpacaJS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict collection alpaca j ses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (DictCollectionAlpacaJS dictCollectionAlpacaJS : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictCollectionAlpacaJS);
		}
	}

	/**
	 * Returns the number of dict collection alpaca j ses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dict collection alpaca j ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTCOLLECTIONALPACAJS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "dictCollectionAlpacaJS.groupId = ?";

	public DictCollectionAlpacaJSPersistenceImpl() {
		setModelClass(DictCollectionAlpacaJS.class);
	}

	/**
	 * Caches the dict collection alpaca j s in the entity cache if it is enabled.
	 *
	 * @param dictCollectionAlpacaJS the dict collection alpaca j s
	 */
	@Override
	public void cacheResult(DictCollectionAlpacaJS dictCollectionAlpacaJS) {
		EntityCacheUtil.putResult(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionAlpacaJSImpl.class,
			dictCollectionAlpacaJS.getPrimaryKey(), dictCollectionAlpacaJS);

		dictCollectionAlpacaJS.resetOriginalValues();
	}

	/**
	 * Caches the dict collection alpaca j ses in the entity cache if it is enabled.
	 *
	 * @param dictCollectionAlpacaJSs the dict collection alpaca j ses
	 */
	@Override
	public void cacheResult(
		List<DictCollectionAlpacaJS> dictCollectionAlpacaJSs) {
		for (DictCollectionAlpacaJS dictCollectionAlpacaJS : dictCollectionAlpacaJSs) {
			if (EntityCacheUtil.getResult(
						DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
						DictCollectionAlpacaJSImpl.class,
						dictCollectionAlpacaJS.getPrimaryKey()) == null) {
				cacheResult(dictCollectionAlpacaJS);
			}
			else {
				dictCollectionAlpacaJS.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dict collection alpaca j ses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DictCollectionAlpacaJSImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DictCollectionAlpacaJSImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dict collection alpaca j s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DictCollectionAlpacaJS dictCollectionAlpacaJS) {
		EntityCacheUtil.removeResult(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionAlpacaJSImpl.class,
			dictCollectionAlpacaJS.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DictCollectionAlpacaJS> dictCollectionAlpacaJSs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DictCollectionAlpacaJS dictCollectionAlpacaJS : dictCollectionAlpacaJSs) {
			EntityCacheUtil.removeResult(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
				DictCollectionAlpacaJSImpl.class,
				dictCollectionAlpacaJS.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dict collection alpaca j s with the primary key. Does not add the dict collection alpaca j s to the database.
	 *
	 * @param dictCollectionId the primary key for the new dict collection alpaca j s
	 * @return the new dict collection alpaca j s
	 */
	@Override
	public DictCollectionAlpacaJS create(long dictCollectionId) {
		DictCollectionAlpacaJS dictCollectionAlpacaJS = new DictCollectionAlpacaJSImpl();

		dictCollectionAlpacaJS.setNew(true);
		dictCollectionAlpacaJS.setPrimaryKey(dictCollectionId);

		return dictCollectionAlpacaJS;
	}

	/**
	 * Removes the dict collection alpaca j s with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictCollectionId the primary key of the dict collection alpaca j s
	 * @return the dict collection alpaca j s that was removed
	 * @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a dict collection alpaca j s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS remove(long dictCollectionId)
		throws NoSuchDictCollectionAlpacaJSException, SystemException {
		return remove((Serializable)dictCollectionId);
	}

	/**
	 * Removes the dict collection alpaca j s with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dict collection alpaca j s
	 * @return the dict collection alpaca j s that was removed
	 * @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a dict collection alpaca j s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS remove(Serializable primaryKey)
		throws NoSuchDictCollectionAlpacaJSException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DictCollectionAlpacaJS dictCollectionAlpacaJS = (DictCollectionAlpacaJS)session.get(DictCollectionAlpacaJSImpl.class,
					primaryKey);

			if (dictCollectionAlpacaJS == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictCollectionAlpacaJSException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictCollectionAlpacaJS);
		}
		catch (NoSuchDictCollectionAlpacaJSException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DictCollectionAlpacaJS removeImpl(
		DictCollectionAlpacaJS dictCollectionAlpacaJS)
		throws SystemException {
		dictCollectionAlpacaJS = toUnwrappedModel(dictCollectionAlpacaJS);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictCollectionAlpacaJS)) {
				dictCollectionAlpacaJS = (DictCollectionAlpacaJS)session.get(DictCollectionAlpacaJSImpl.class,
						dictCollectionAlpacaJS.getPrimaryKeyObj());
			}

			if (dictCollectionAlpacaJS != null) {
				session.delete(dictCollectionAlpacaJS);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictCollectionAlpacaJS != null) {
			clearCache(dictCollectionAlpacaJS);
		}

		return dictCollectionAlpacaJS;
	}

	@Override
	public DictCollectionAlpacaJS updateImpl(
		com.dict.dao.model.DictCollectionAlpacaJS dictCollectionAlpacaJS)
		throws SystemException {
		dictCollectionAlpacaJS = toUnwrappedModel(dictCollectionAlpacaJS);

		boolean isNew = dictCollectionAlpacaJS.isNew();

		DictCollectionAlpacaJSModelImpl dictCollectionAlpacaJSModelImpl = (DictCollectionAlpacaJSModelImpl)dictCollectionAlpacaJS;

		Session session = null;

		try {
			session = openSession();

			if (dictCollectionAlpacaJS.isNew()) {
				session.save(dictCollectionAlpacaJS);

				dictCollectionAlpacaJS.setNew(false);
			}
			else {
				session.merge(dictCollectionAlpacaJS);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DictCollectionAlpacaJSModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dictCollectionAlpacaJSModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictCollectionAlpacaJSModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { dictCollectionAlpacaJSModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionAlpacaJSImpl.class,
			dictCollectionAlpacaJS.getPrimaryKey(), dictCollectionAlpacaJS);

		return dictCollectionAlpacaJS;
	}

	protected DictCollectionAlpacaJS toUnwrappedModel(
		DictCollectionAlpacaJS dictCollectionAlpacaJS) {
		if (dictCollectionAlpacaJS instanceof DictCollectionAlpacaJSImpl) {
			return dictCollectionAlpacaJS;
		}

		DictCollectionAlpacaJSImpl dictCollectionAlpacaJSImpl = new DictCollectionAlpacaJSImpl();

		dictCollectionAlpacaJSImpl.setNew(dictCollectionAlpacaJS.isNew());
		dictCollectionAlpacaJSImpl.setPrimaryKey(dictCollectionAlpacaJS.getPrimaryKey());

		dictCollectionAlpacaJSImpl.setDictCollectionId(dictCollectionAlpacaJS.getDictCollectionId());
		dictCollectionAlpacaJSImpl.setCompanyId(dictCollectionAlpacaJS.getCompanyId());
		dictCollectionAlpacaJSImpl.setGroupId(dictCollectionAlpacaJS.getGroupId());
		dictCollectionAlpacaJSImpl.setUserId(dictCollectionAlpacaJS.getUserId());
		dictCollectionAlpacaJSImpl.setCreateDate(dictCollectionAlpacaJS.getCreateDate());
		dictCollectionAlpacaJSImpl.setModifiedDate(dictCollectionAlpacaJS.getModifiedDate());
		dictCollectionAlpacaJSImpl.setCollectionCode(dictCollectionAlpacaJS.getCollectionCode());
		dictCollectionAlpacaJSImpl.setCollectionName(dictCollectionAlpacaJS.getCollectionName());
		dictCollectionAlpacaJSImpl.setDescription(dictCollectionAlpacaJS.getDescription());

		return dictCollectionAlpacaJSImpl;
	}

	/**
	 * Returns the dict collection alpaca j s with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dict collection alpaca j s
	 * @return the dict collection alpaca j s
	 * @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a dict collection alpaca j s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictCollectionAlpacaJSException, SystemException {
		DictCollectionAlpacaJS dictCollectionAlpacaJS = fetchByPrimaryKey(primaryKey);

		if (dictCollectionAlpacaJS == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictCollectionAlpacaJSException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictCollectionAlpacaJS;
	}

	/**
	 * Returns the dict collection alpaca j s with the primary key or throws a {@link com.dict.dao.NoSuchDictCollectionAlpacaJSException} if it could not be found.
	 *
	 * @param dictCollectionId the primary key of the dict collection alpaca j s
	 * @return the dict collection alpaca j s
	 * @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a dict collection alpaca j s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS findByPrimaryKey(long dictCollectionId)
		throws NoSuchDictCollectionAlpacaJSException, SystemException {
		return findByPrimaryKey((Serializable)dictCollectionId);
	}

	/**
	 * Returns the dict collection alpaca j s with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dict collection alpaca j s
	 * @return the dict collection alpaca j s, or <code>null</code> if a dict collection alpaca j s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DictCollectionAlpacaJS dictCollectionAlpacaJS = (DictCollectionAlpacaJS)EntityCacheUtil.getResult(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
				DictCollectionAlpacaJSImpl.class, primaryKey);

		if (dictCollectionAlpacaJS == _nullDictCollectionAlpacaJS) {
			return null;
		}

		if (dictCollectionAlpacaJS == null) {
			Session session = null;

			try {
				session = openSession();

				dictCollectionAlpacaJS = (DictCollectionAlpacaJS)session.get(DictCollectionAlpacaJSImpl.class,
						primaryKey);

				if (dictCollectionAlpacaJS != null) {
					cacheResult(dictCollectionAlpacaJS);
				}
				else {
					EntityCacheUtil.putResult(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
						DictCollectionAlpacaJSImpl.class, primaryKey,
						_nullDictCollectionAlpacaJS);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DictCollectionAlpacaJSModelImpl.ENTITY_CACHE_ENABLED,
					DictCollectionAlpacaJSImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictCollectionAlpacaJS;
	}

	/**
	 * Returns the dict collection alpaca j s with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictCollectionId the primary key of the dict collection alpaca j s
	 * @return the dict collection alpaca j s, or <code>null</code> if a dict collection alpaca j s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollectionAlpacaJS fetchByPrimaryKey(long dictCollectionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dictCollectionId);
	}

	/**
	 * Returns all the dict collection alpaca j ses.
	 *
	 * @return the dict collection alpaca j ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollectionAlpacaJS> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict collection alpaca j ses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dict.dao.model.impl.DictCollectionAlpacaJSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dict collection alpaca j ses
	 * @param end the upper bound of the range of dict collection alpaca j ses (not inclusive)
	 * @return the range of dict collection alpaca j ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollectionAlpacaJS> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict collection alpaca j ses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dict.dao.model.impl.DictCollectionAlpacaJSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dict collection alpaca j ses
	 * @param end the upper bound of the range of dict collection alpaca j ses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dict collection alpaca j ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollectionAlpacaJS> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DictCollectionAlpacaJS> list = (List<DictCollectionAlpacaJS>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DICTCOLLECTIONALPACAJS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTCOLLECTIONALPACAJS;

				if (pagination) {
					sql = sql.concat(DictCollectionAlpacaJSModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DictCollectionAlpacaJS>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictCollectionAlpacaJS>(list);
				}
				else {
					list = (List<DictCollectionAlpacaJS>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dict collection alpaca j ses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DictCollectionAlpacaJS dictCollectionAlpacaJS : findAll()) {
			remove(dictCollectionAlpacaJS);
		}
	}

	/**
	 * Returns the number of dict collection alpaca j ses.
	 *
	 * @return the number of dict collection alpaca j ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DICTCOLLECTIONALPACAJS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the dict collection alpaca j s persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.dict.dao.model.DictCollectionAlpacaJS")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DictCollectionAlpacaJS>> listenersList = new ArrayList<ModelListener<DictCollectionAlpacaJS>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DictCollectionAlpacaJS>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DictCollectionAlpacaJSImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DICTCOLLECTIONALPACAJS = "SELECT dictCollectionAlpacaJS FROM DictCollectionAlpacaJS dictCollectionAlpacaJS";
	private static final String _SQL_SELECT_DICTCOLLECTIONALPACAJS_WHERE = "SELECT dictCollectionAlpacaJS FROM DictCollectionAlpacaJS dictCollectionAlpacaJS WHERE ";
	private static final String _SQL_COUNT_DICTCOLLECTIONALPACAJS = "SELECT COUNT(dictCollectionAlpacaJS) FROM DictCollectionAlpacaJS dictCollectionAlpacaJS";
	private static final String _SQL_COUNT_DICTCOLLECTIONALPACAJS_WHERE = "SELECT COUNT(dictCollectionAlpacaJS) FROM DictCollectionAlpacaJS dictCollectionAlpacaJS WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictCollectionAlpacaJS.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DictCollectionAlpacaJS exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DictCollectionAlpacaJS exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DictCollectionAlpacaJSPersistenceImpl.class);
	private static DictCollectionAlpacaJS _nullDictCollectionAlpacaJS = new DictCollectionAlpacaJSImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DictCollectionAlpacaJS> toCacheModel() {
				return _nullDictCollectionAlpacaJSCacheModel;
			}
		};

	private static CacheModel<DictCollectionAlpacaJS> _nullDictCollectionAlpacaJSCacheModel =
		new CacheModel<DictCollectionAlpacaJS>() {
			@Override
			public DictCollectionAlpacaJS toEntityModel() {
				return _nullDictCollectionAlpacaJS;
			}
		};
}