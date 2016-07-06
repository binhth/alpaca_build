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

package com.dict.dao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DictCollectionAlpacaJSLocalService}.
 *
 * @author binhth
 * @see DictCollectionAlpacaJSLocalService
 * @generated
 */
public class DictCollectionAlpacaJSLocalServiceWrapper
	implements DictCollectionAlpacaJSLocalService,
		ServiceWrapper<DictCollectionAlpacaJSLocalService> {
	public DictCollectionAlpacaJSLocalServiceWrapper(
		DictCollectionAlpacaJSLocalService dictCollectionAlpacaJSLocalService) {
		_dictCollectionAlpacaJSLocalService = dictCollectionAlpacaJSLocalService;
	}

	/**
	* Adds the dict collection alpaca j s to the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollectionAlpacaJS the dict collection alpaca j s
	* @return the dict collection alpaca j s that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dict.dao.model.DictCollectionAlpacaJS addDictCollectionAlpacaJS(
		com.dict.dao.model.DictCollectionAlpacaJS dictCollectionAlpacaJS)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.addDictCollectionAlpacaJS(dictCollectionAlpacaJS);
	}

	/**
	* Creates a new dict collection alpaca j s with the primary key. Does not add the dict collection alpaca j s to the database.
	*
	* @param dictCollectionId the primary key for the new dict collection alpaca j s
	* @return the new dict collection alpaca j s
	*/
	@Override
	public com.dict.dao.model.DictCollectionAlpacaJS createDictCollectionAlpacaJS(
		long dictCollectionId) {
		return _dictCollectionAlpacaJSLocalService.createDictCollectionAlpacaJS(dictCollectionId);
	}

	/**
	* Deletes the dict collection alpaca j s with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollectionId the primary key of the dict collection alpaca j s
	* @return the dict collection alpaca j s that was removed
	* @throws PortalException if a dict collection alpaca j s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dict.dao.model.DictCollectionAlpacaJS deleteDictCollectionAlpacaJS(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.deleteDictCollectionAlpacaJS(dictCollectionId);
	}

	/**
	* Deletes the dict collection alpaca j s from the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollectionAlpacaJS the dict collection alpaca j s
	* @return the dict collection alpaca j s that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dict.dao.model.DictCollectionAlpacaJS deleteDictCollectionAlpacaJS(
		com.dict.dao.model.DictCollectionAlpacaJS dictCollectionAlpacaJS)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.deleteDictCollectionAlpacaJS(dictCollectionAlpacaJS);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dictCollectionAlpacaJSLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dict.dao.model.impl.DictCollectionAlpacaJSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dict.dao.model.impl.DictCollectionAlpacaJSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.dict.dao.model.DictCollectionAlpacaJS fetchDictCollectionAlpacaJS(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.fetchDictCollectionAlpacaJS(dictCollectionId);
	}

	/**
	* Returns the dict collection alpaca j s with the primary key.
	*
	* @param dictCollectionId the primary key of the dict collection alpaca j s
	* @return the dict collection alpaca j s
	* @throws PortalException if a dict collection alpaca j s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dict.dao.model.DictCollectionAlpacaJS getDictCollectionAlpacaJS(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.getDictCollectionAlpacaJS(dictCollectionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.dict.dao.model.DictCollectionAlpacaJS> getDictCollectionAlpacaJSs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.getDictCollectionAlpacaJSs(start,
			end);
	}

	/**
	* Returns the number of dict collection alpaca j ses.
	*
	* @return the number of dict collection alpaca j ses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDictCollectionAlpacaJSsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.getDictCollectionAlpacaJSsCount();
	}

	/**
	* Updates the dict collection alpaca j s in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictCollectionAlpacaJS the dict collection alpaca j s
	* @return the dict collection alpaca j s that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dict.dao.model.DictCollectionAlpacaJS updateDictCollectionAlpacaJS(
		com.dict.dao.model.DictCollectionAlpacaJS dictCollectionAlpacaJS)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.updateDictCollectionAlpacaJS(dictCollectionAlpacaJS);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dictCollectionAlpacaJSLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dictCollectionAlpacaJSLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dictCollectionAlpacaJSLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.dict.dao.model.DictCollectionAlpacaJS> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.findByGroupId(groupId);
	}

	@Override
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJSLocalService.countByGroupId(groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DictCollectionAlpacaJSLocalService getWrappedDictCollectionAlpacaJSLocalService() {
		return _dictCollectionAlpacaJSLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDictCollectionAlpacaJSLocalService(
		DictCollectionAlpacaJSLocalService dictCollectionAlpacaJSLocalService) {
		_dictCollectionAlpacaJSLocalService = dictCollectionAlpacaJSLocalService;
	}

	@Override
	public DictCollectionAlpacaJSLocalService getWrappedService() {
		return _dictCollectionAlpacaJSLocalService;
	}

	@Override
	public void setWrappedService(
		DictCollectionAlpacaJSLocalService dictCollectionAlpacaJSLocalService) {
		_dictCollectionAlpacaJSLocalService = dictCollectionAlpacaJSLocalService;
	}

	private DictCollectionAlpacaJSLocalService _dictCollectionAlpacaJSLocalService;
}