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

import com.dict.dao.model.DictCollectionAlpacaJS;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the dict collection alpaca j s service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author binhth
 * @see DictCollectionAlpacaJSPersistenceImpl
 * @see DictCollectionAlpacaJSUtil
 * @generated
 */
public interface DictCollectionAlpacaJSPersistence extends BasePersistence<DictCollectionAlpacaJS> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DictCollectionAlpacaJSUtil} to access the dict collection alpaca j s persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dict collection alpaca j ses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dict collection alpaca j ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dict.dao.model.DictCollectionAlpacaJS> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dict.dao.model.DictCollectionAlpacaJS> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dict.dao.model.DictCollectionAlpacaJS> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict collection alpaca j s in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict collection alpaca j s
	* @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a matching dict collection alpaca j s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dict.dao.model.DictCollectionAlpacaJS findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dict.dao.NoSuchDictCollectionAlpacaJSException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict collection alpaca j s in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict collection alpaca j s, or <code>null</code> if a matching dict collection alpaca j s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dict.dao.model.DictCollectionAlpacaJS fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict collection alpaca j s in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict collection alpaca j s
	* @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a matching dict collection alpaca j s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dict.dao.model.DictCollectionAlpacaJS findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dict.dao.NoSuchDictCollectionAlpacaJSException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict collection alpaca j s in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict collection alpaca j s, or <code>null</code> if a matching dict collection alpaca j s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dict.dao.model.DictCollectionAlpacaJS fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.dict.dao.model.DictCollectionAlpacaJS[] findByGroupId_PrevAndNext(
		long dictCollectionId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dict.dao.NoSuchDictCollectionAlpacaJSException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dict collection alpaca j ses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict collection alpaca j ses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dict collection alpaca j ses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dict collection alpaca j s in the entity cache if it is enabled.
	*
	* @param dictCollectionAlpacaJS the dict collection alpaca j s
	*/
	public void cacheResult(
		com.dict.dao.model.DictCollectionAlpacaJS dictCollectionAlpacaJS);

	/**
	* Caches the dict collection alpaca j ses in the entity cache if it is enabled.
	*
	* @param dictCollectionAlpacaJSs the dict collection alpaca j ses
	*/
	public void cacheResult(
		java.util.List<com.dict.dao.model.DictCollectionAlpacaJS> dictCollectionAlpacaJSs);

	/**
	* Creates a new dict collection alpaca j s with the primary key. Does not add the dict collection alpaca j s to the database.
	*
	* @param dictCollectionId the primary key for the new dict collection alpaca j s
	* @return the new dict collection alpaca j s
	*/
	public com.dict.dao.model.DictCollectionAlpacaJS create(
		long dictCollectionId);

	/**
	* Removes the dict collection alpaca j s with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollectionId the primary key of the dict collection alpaca j s
	* @return the dict collection alpaca j s that was removed
	* @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a dict collection alpaca j s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dict.dao.model.DictCollectionAlpacaJS remove(
		long dictCollectionId)
		throws com.dict.dao.NoSuchDictCollectionAlpacaJSException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.dict.dao.model.DictCollectionAlpacaJS updateImpl(
		com.dict.dao.model.DictCollectionAlpacaJS dictCollectionAlpacaJS)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collection alpaca j s with the primary key or throws a {@link com.dict.dao.NoSuchDictCollectionAlpacaJSException} if it could not be found.
	*
	* @param dictCollectionId the primary key of the dict collection alpaca j s
	* @return the dict collection alpaca j s
	* @throws com.dict.dao.NoSuchDictCollectionAlpacaJSException if a dict collection alpaca j s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dict.dao.model.DictCollectionAlpacaJS findByPrimaryKey(
		long dictCollectionId)
		throws com.dict.dao.NoSuchDictCollectionAlpacaJSException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collection alpaca j s with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictCollectionId the primary key of the dict collection alpaca j s
	* @return the dict collection alpaca j s, or <code>null</code> if a dict collection alpaca j s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dict.dao.model.DictCollectionAlpacaJS fetchByPrimaryKey(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict collection alpaca j ses.
	*
	* @return the dict collection alpaca j ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dict.dao.model.DictCollectionAlpacaJS> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dict.dao.model.DictCollectionAlpacaJS> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dict.dao.model.DictCollectionAlpacaJS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dict collection alpaca j ses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict collection alpaca j ses.
	*
	* @return the number of dict collection alpaca j ses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}