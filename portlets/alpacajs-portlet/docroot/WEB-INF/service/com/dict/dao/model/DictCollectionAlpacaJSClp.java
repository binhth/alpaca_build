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

import com.dict.dao.service.ClpSerializer;
import com.dict.dao.service.DictCollectionAlpacaJSLocalServiceUtil;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author binhth
 */
public class DictCollectionAlpacaJSClp extends BaseModelImpl<DictCollectionAlpacaJS>
	implements DictCollectionAlpacaJS {
	public DictCollectionAlpacaJSClp() {
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
	public long getPrimaryKey() {
		return _dictCollectionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictCollectionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictCollectionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getDictCollectionId() {
		return _dictCollectionId;
	}

	@Override
	public void setDictCollectionId(long dictCollectionId) {
		_dictCollectionId = dictCollectionId;

		if (_dictCollectionAlpacaJSRemoteModel != null) {
			try {
				Class<?> clazz = _dictCollectionAlpacaJSRemoteModel.getClass();

				Method method = clazz.getMethod("setDictCollectionId",
						long.class);

				method.invoke(_dictCollectionAlpacaJSRemoteModel,
					dictCollectionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_dictCollectionAlpacaJSRemoteModel != null) {
			try {
				Class<?> clazz = _dictCollectionAlpacaJSRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dictCollectionAlpacaJSRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_dictCollectionAlpacaJSRemoteModel != null) {
			try {
				Class<?> clazz = _dictCollectionAlpacaJSRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dictCollectionAlpacaJSRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_dictCollectionAlpacaJSRemoteModel != null) {
			try {
				Class<?> clazz = _dictCollectionAlpacaJSRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dictCollectionAlpacaJSRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_dictCollectionAlpacaJSRemoteModel != null) {
			try {
				Class<?> clazz = _dictCollectionAlpacaJSRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dictCollectionAlpacaJSRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_dictCollectionAlpacaJSRemoteModel != null) {
			try {
				Class<?> clazz = _dictCollectionAlpacaJSRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dictCollectionAlpacaJSRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionCode() {
		return _collectionCode;
	}

	@Override
	public void setCollectionCode(String collectionCode) {
		_collectionCode = collectionCode;

		if (_dictCollectionAlpacaJSRemoteModel != null) {
			try {
				Class<?> clazz = _dictCollectionAlpacaJSRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionCode",
						String.class);

				method.invoke(_dictCollectionAlpacaJSRemoteModel, collectionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionName() {
		return _collectionName;
	}

	@Override
	public String getCollectionName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCollectionName(languageId);
	}

	@Override
	public String getCollectionName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCollectionName(languageId, useDefault);
	}

	@Override
	public String getCollectionName(String languageId) {
		return LocalizationUtil.getLocalization(getCollectionName(), languageId);
	}

	@Override
	public String getCollectionName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getCollectionName(),
			languageId, useDefault);
	}

	@Override
	public String getCollectionNameCurrentLanguageId() {
		return _collectionNameCurrentLanguageId;
	}

	@Override
	public String getCollectionNameCurrentValue() {
		Locale locale = getLocale(_collectionNameCurrentLanguageId);

		return getCollectionName(locale);
	}

	@Override
	public Map<Locale, String> getCollectionNameMap() {
		return LocalizationUtil.getLocalizationMap(getCollectionName());
	}

	@Override
	public void setCollectionName(String collectionName) {
		_collectionName = collectionName;

		if (_dictCollectionAlpacaJSRemoteModel != null) {
			try {
				Class<?> clazz = _dictCollectionAlpacaJSRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionName",
						String.class);

				method.invoke(_dictCollectionAlpacaJSRemoteModel, collectionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setCollectionName(String collectionName, Locale locale) {
		setCollectionName(collectionName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setCollectionName(String collectionName, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(collectionName)) {
			setCollectionName(LocalizationUtil.updateLocalization(
					getCollectionName(), "CollectionName", collectionName,
					languageId, defaultLanguageId));
		}
		else {
			setCollectionName(LocalizationUtil.removeLocalization(
					getCollectionName(), "CollectionName", languageId));
		}
	}

	@Override
	public void setCollectionNameCurrentLanguageId(String languageId) {
		_collectionNameCurrentLanguageId = languageId;
	}

	@Override
	public void setCollectionNameMap(Map<Locale, String> collectionNameMap) {
		setCollectionNameMap(collectionNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setCollectionNameMap(Map<Locale, String> collectionNameMap,
		Locale defaultLocale) {
		if (collectionNameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setCollectionName(LocalizationUtil.updateLocalization(
					collectionNameMap, getCollectionName(), "CollectionName",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_dictCollectionAlpacaJSRemoteModel != null) {
			try {
				Class<?> clazz = _dictCollectionAlpacaJSRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_dictCollectionAlpacaJSRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDictCollectionAlpacaJSRemoteModel() {
		return _dictCollectionAlpacaJSRemoteModel;
	}

	public void setDictCollectionAlpacaJSRemoteModel(
		BaseModel<?> dictCollectionAlpacaJSRemoteModel) {
		_dictCollectionAlpacaJSRemoteModel = dictCollectionAlpacaJSRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _dictCollectionAlpacaJSRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_dictCollectionAlpacaJSRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DictCollectionAlpacaJSLocalServiceUtil.addDictCollectionAlpacaJS(this);
		}
		else {
			DictCollectionAlpacaJSLocalServiceUtil.updateDictCollectionAlpacaJS(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> collectionNameMap = getCollectionNameMap();

		for (Map.Entry<Locale, String> entry : collectionNameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getCollectionName();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String collectionName = getCollectionName(defaultLocale);

		if (Validator.isNull(collectionName)) {
			setCollectionName(getCollectionName(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setCollectionName(getCollectionName(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public DictCollectionAlpacaJS toEscapedModel() {
		return (DictCollectionAlpacaJS)ProxyUtil.newProxyInstance(DictCollectionAlpacaJS.class.getClassLoader(),
			new Class[] { DictCollectionAlpacaJS.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DictCollectionAlpacaJSClp clone = new DictCollectionAlpacaJSClp();

		clone.setDictCollectionId(getDictCollectionId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCollectionCode(getCollectionCode());
		clone.setCollectionName(getCollectionName());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(DictCollectionAlpacaJS dictCollectionAlpacaJS) {
		int value = 0;

		value = getCollectionName()
					.compareTo(dictCollectionAlpacaJS.getCollectionName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictCollectionAlpacaJSClp)) {
			return false;
		}

		DictCollectionAlpacaJSClp dictCollectionAlpacaJS = (DictCollectionAlpacaJSClp)obj;

		long primaryKey = dictCollectionAlpacaJS.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{dictCollectionId=");
		sb.append(getDictCollectionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", collectionCode=");
		sb.append(getCollectionCode());
		sb.append(", collectionName=");
		sb.append(getCollectionName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.dict.dao.model.DictCollectionAlpacaJS");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dictCollectionId</column-name><column-value><![CDATA[");
		sb.append(getDictCollectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionCode</column-name><column-value><![CDATA[");
		sb.append(getCollectionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionName</column-name><column-value><![CDATA[");
		sb.append(getCollectionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dictCollectionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _collectionCode;
	private String _collectionName;
	private String _collectionNameCurrentLanguageId;
	private String _description;
	private BaseModel<?> _dictCollectionAlpacaJSRemoteModel;
	private Class<?> _clpSerializerClass = com.dict.dao.service.ClpSerializer.class;
}