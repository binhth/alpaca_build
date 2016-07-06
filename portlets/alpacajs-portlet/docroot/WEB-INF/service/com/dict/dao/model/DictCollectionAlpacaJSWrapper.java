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

package com.dict.dao.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DictCollectionAlpacaJS}.
 * </p>
 *
 * @author binhth
 * @see DictCollectionAlpacaJS
 * @generated
 */
public class DictCollectionAlpacaJSWrapper implements DictCollectionAlpacaJS,
	ModelWrapper<DictCollectionAlpacaJS> {
	public DictCollectionAlpacaJSWrapper(
		DictCollectionAlpacaJS dictCollectionAlpacaJS) {
		_dictCollectionAlpacaJS = dictCollectionAlpacaJS;
	}

	@Override
	public Class<?> getModelClass() {
		return DictCollectionAlpacaJS.class;
	}

	@Override
	public String getModelClassName() {
		return DictCollectionAlpacaJS.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictCollectionId", getDictCollectionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("collectionCode", getCollectionCode());
		attributes.put("collectionName", getCollectionName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictCollectionId = (Long)attributes.get("dictCollectionId");

		if (dictCollectionId != null) {
			setDictCollectionId(dictCollectionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String collectionCode = (String)attributes.get("collectionCode");

		if (collectionCode != null) {
			setCollectionCode(collectionCode);
		}

		String collectionName = (String)attributes.get("collectionName");

		if (collectionName != null) {
			setCollectionName(collectionName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this dict collection alpaca j s.
	*
	* @return the primary key of this dict collection alpaca j s
	*/
	@Override
	public long getPrimaryKey() {
		return _dictCollectionAlpacaJS.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dict collection alpaca j s.
	*
	* @param primaryKey the primary key of this dict collection alpaca j s
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictCollectionAlpacaJS.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dict collection ID of this dict collection alpaca j s.
	*
	* @return the dict collection ID of this dict collection alpaca j s
	*/
	@Override
	public long getDictCollectionId() {
		return _dictCollectionAlpacaJS.getDictCollectionId();
	}

	/**
	* Sets the dict collection ID of this dict collection alpaca j s.
	*
	* @param dictCollectionId the dict collection ID of this dict collection alpaca j s
	*/
	@Override
	public void setDictCollectionId(long dictCollectionId) {
		_dictCollectionAlpacaJS.setDictCollectionId(dictCollectionId);
	}

	/**
	* Returns the company ID of this dict collection alpaca j s.
	*
	* @return the company ID of this dict collection alpaca j s
	*/
	@Override
	public long getCompanyId() {
		return _dictCollectionAlpacaJS.getCompanyId();
	}

	/**
	* Sets the company ID of this dict collection alpaca j s.
	*
	* @param companyId the company ID of this dict collection alpaca j s
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dictCollectionAlpacaJS.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dict collection alpaca j s.
	*
	* @return the group ID of this dict collection alpaca j s
	*/
	@Override
	public long getGroupId() {
		return _dictCollectionAlpacaJS.getGroupId();
	}

	/**
	* Sets the group ID of this dict collection alpaca j s.
	*
	* @param groupId the group ID of this dict collection alpaca j s
	*/
	@Override
	public void setGroupId(long groupId) {
		_dictCollectionAlpacaJS.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dict collection alpaca j s.
	*
	* @return the user ID of this dict collection alpaca j s
	*/
	@Override
	public long getUserId() {
		return _dictCollectionAlpacaJS.getUserId();
	}

	/**
	* Sets the user ID of this dict collection alpaca j s.
	*
	* @param userId the user ID of this dict collection alpaca j s
	*/
	@Override
	public void setUserId(long userId) {
		_dictCollectionAlpacaJS.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dict collection alpaca j s.
	*
	* @return the user uuid of this dict collection alpaca j s
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollectionAlpacaJS.getUserUuid();
	}

	/**
	* Sets the user uuid of this dict collection alpaca j s.
	*
	* @param userUuid the user uuid of this dict collection alpaca j s
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dictCollectionAlpacaJS.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dict collection alpaca j s.
	*
	* @return the create date of this dict collection alpaca j s
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dictCollectionAlpacaJS.getCreateDate();
	}

	/**
	* Sets the create date of this dict collection alpaca j s.
	*
	* @param createDate the create date of this dict collection alpaca j s
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dictCollectionAlpacaJS.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dict collection alpaca j s.
	*
	* @return the modified date of this dict collection alpaca j s
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dictCollectionAlpacaJS.getModifiedDate();
	}

	/**
	* Sets the modified date of this dict collection alpaca j s.
	*
	* @param modifiedDate the modified date of this dict collection alpaca j s
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dictCollectionAlpacaJS.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the collection code of this dict collection alpaca j s.
	*
	* @return the collection code of this dict collection alpaca j s
	*/
	@Override
	public java.lang.String getCollectionCode() {
		return _dictCollectionAlpacaJS.getCollectionCode();
	}

	/**
	* Sets the collection code of this dict collection alpaca j s.
	*
	* @param collectionCode the collection code of this dict collection alpaca j s
	*/
	@Override
	public void setCollectionCode(java.lang.String collectionCode) {
		_dictCollectionAlpacaJS.setCollectionCode(collectionCode);
	}

	/**
	* Returns the collection name of this dict collection alpaca j s.
	*
	* @return the collection name of this dict collection alpaca j s
	*/
	@Override
	public java.lang.String getCollectionName() {
		return _dictCollectionAlpacaJS.getCollectionName();
	}

	/**
	* Returns the localized collection name of this dict collection alpaca j s in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized collection name of this dict collection alpaca j s
	*/
	@Override
	public java.lang.String getCollectionName(java.util.Locale locale) {
		return _dictCollectionAlpacaJS.getCollectionName(locale);
	}

	/**
	* Returns the localized collection name of this dict collection alpaca j s in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized collection name of this dict collection alpaca j s. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getCollectionName(java.util.Locale locale,
		boolean useDefault) {
		return _dictCollectionAlpacaJS.getCollectionName(locale, useDefault);
	}

	/**
	* Returns the localized collection name of this dict collection alpaca j s in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized collection name of this dict collection alpaca j s
	*/
	@Override
	public java.lang.String getCollectionName(java.lang.String languageId) {
		return _dictCollectionAlpacaJS.getCollectionName(languageId);
	}

	/**
	* Returns the localized collection name of this dict collection alpaca j s in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized collection name of this dict collection alpaca j s
	*/
	@Override
	public java.lang.String getCollectionName(java.lang.String languageId,
		boolean useDefault) {
		return _dictCollectionAlpacaJS.getCollectionName(languageId, useDefault);
	}

	@Override
	public java.lang.String getCollectionNameCurrentLanguageId() {
		return _dictCollectionAlpacaJS.getCollectionNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getCollectionNameCurrentValue() {
		return _dictCollectionAlpacaJS.getCollectionNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized collection names of this dict collection alpaca j s.
	*
	* @return the locales and localized collection names of this dict collection alpaca j s
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getCollectionNameMap() {
		return _dictCollectionAlpacaJS.getCollectionNameMap();
	}

	/**
	* Sets the collection name of this dict collection alpaca j s.
	*
	* @param collectionName the collection name of this dict collection alpaca j s
	*/
	@Override
	public void setCollectionName(java.lang.String collectionName) {
		_dictCollectionAlpacaJS.setCollectionName(collectionName);
	}

	/**
	* Sets the localized collection name of this dict collection alpaca j s in the language.
	*
	* @param collectionName the localized collection name of this dict collection alpaca j s
	* @param locale the locale of the language
	*/
	@Override
	public void setCollectionName(java.lang.String collectionName,
		java.util.Locale locale) {
		_dictCollectionAlpacaJS.setCollectionName(collectionName, locale);
	}

	/**
	* Sets the localized collection name of this dict collection alpaca j s in the language, and sets the default locale.
	*
	* @param collectionName the localized collection name of this dict collection alpaca j s
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setCollectionName(java.lang.String collectionName,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_dictCollectionAlpacaJS.setCollectionName(collectionName, locale,
			defaultLocale);
	}

	@Override
	public void setCollectionNameCurrentLanguageId(java.lang.String languageId) {
		_dictCollectionAlpacaJS.setCollectionNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized collection names of this dict collection alpaca j s from the map of locales and localized collection names.
	*
	* @param collectionNameMap the locales and localized collection names of this dict collection alpaca j s
	*/
	@Override
	public void setCollectionNameMap(
		java.util.Map<java.util.Locale, java.lang.String> collectionNameMap) {
		_dictCollectionAlpacaJS.setCollectionNameMap(collectionNameMap);
	}

	/**
	* Sets the localized collection names of this dict collection alpaca j s from the map of locales and localized collection names, and sets the default locale.
	*
	* @param collectionNameMap the locales and localized collection names of this dict collection alpaca j s
	* @param defaultLocale the default locale
	*/
	@Override
	public void setCollectionNameMap(
		java.util.Map<java.util.Locale, java.lang.String> collectionNameMap,
		java.util.Locale defaultLocale) {
		_dictCollectionAlpacaJS.setCollectionNameMap(collectionNameMap,
			defaultLocale);
	}

	/**
	* Returns the description of this dict collection alpaca j s.
	*
	* @return the description of this dict collection alpaca j s
	*/
	@Override
	public java.lang.String getDescription() {
		return _dictCollectionAlpacaJS.getDescription();
	}

	/**
	* Sets the description of this dict collection alpaca j s.
	*
	* @param description the description of this dict collection alpaca j s
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_dictCollectionAlpacaJS.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _dictCollectionAlpacaJS.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dictCollectionAlpacaJS.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dictCollectionAlpacaJS.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictCollectionAlpacaJS.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dictCollectionAlpacaJS.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dictCollectionAlpacaJS.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dictCollectionAlpacaJS.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dictCollectionAlpacaJS.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dictCollectionAlpacaJS.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dictCollectionAlpacaJS.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dictCollectionAlpacaJS.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _dictCollectionAlpacaJS.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _dictCollectionAlpacaJS.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_dictCollectionAlpacaJS.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_dictCollectionAlpacaJS.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new DictCollectionAlpacaJSWrapper((DictCollectionAlpacaJS)_dictCollectionAlpacaJS.clone());
	}

	@Override
	public int compareTo(
		com.dict.dao.model.DictCollectionAlpacaJS dictCollectionAlpacaJS) {
		return _dictCollectionAlpacaJS.compareTo(dictCollectionAlpacaJS);
	}

	@Override
	public int hashCode() {
		return _dictCollectionAlpacaJS.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.dict.dao.model.DictCollectionAlpacaJS> toCacheModel() {
		return _dictCollectionAlpacaJS.toCacheModel();
	}

	@Override
	public com.dict.dao.model.DictCollectionAlpacaJS toEscapedModel() {
		return new DictCollectionAlpacaJSWrapper(_dictCollectionAlpacaJS.toEscapedModel());
	}

	@Override
	public com.dict.dao.model.DictCollectionAlpacaJS toUnescapedModel() {
		return new DictCollectionAlpacaJSWrapper(_dictCollectionAlpacaJS.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dictCollectionAlpacaJS.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictCollectionAlpacaJS.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictCollectionAlpacaJS.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictCollectionAlpacaJSWrapper)) {
			return false;
		}

		DictCollectionAlpacaJSWrapper dictCollectionAlpacaJSWrapper = (DictCollectionAlpacaJSWrapper)obj;

		if (Validator.equals(_dictCollectionAlpacaJS,
					dictCollectionAlpacaJSWrapper._dictCollectionAlpacaJS)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DictCollectionAlpacaJS getWrappedDictCollectionAlpacaJS() {
		return _dictCollectionAlpacaJS;
	}

	@Override
	public DictCollectionAlpacaJS getWrappedModel() {
		return _dictCollectionAlpacaJS;
	}

	@Override
	public void resetOriginalValues() {
		_dictCollectionAlpacaJS.resetOriginalValues();
	}

	private DictCollectionAlpacaJS _dictCollectionAlpacaJS;
}