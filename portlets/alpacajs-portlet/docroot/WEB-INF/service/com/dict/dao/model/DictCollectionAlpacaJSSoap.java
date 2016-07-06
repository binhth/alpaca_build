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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.dict.dao.service.http.DictCollectionAlpacaJSServiceSoap}.
 *
 * @author binhth
 * @see com.dict.dao.service.http.DictCollectionAlpacaJSServiceSoap
 * @generated
 */
public class DictCollectionAlpacaJSSoap implements Serializable {
	public static DictCollectionAlpacaJSSoap toSoapModel(
		DictCollectionAlpacaJS model) {
		DictCollectionAlpacaJSSoap soapModel = new DictCollectionAlpacaJSSoap();

		soapModel.setDictCollectionId(model.getDictCollectionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCollectionCode(model.getCollectionCode());
		soapModel.setCollectionName(model.getCollectionName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static DictCollectionAlpacaJSSoap[] toSoapModels(
		DictCollectionAlpacaJS[] models) {
		DictCollectionAlpacaJSSoap[] soapModels = new DictCollectionAlpacaJSSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictCollectionAlpacaJSSoap[][] toSoapModels(
		DictCollectionAlpacaJS[][] models) {
		DictCollectionAlpacaJSSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictCollectionAlpacaJSSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictCollectionAlpacaJSSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictCollectionAlpacaJSSoap[] toSoapModels(
		List<DictCollectionAlpacaJS> models) {
		List<DictCollectionAlpacaJSSoap> soapModels = new ArrayList<DictCollectionAlpacaJSSoap>(models.size());

		for (DictCollectionAlpacaJS model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictCollectionAlpacaJSSoap[soapModels.size()]);
	}

	public DictCollectionAlpacaJSSoap() {
	}

	public long getPrimaryKey() {
		return _dictCollectionId;
	}

	public void setPrimaryKey(long pk) {
		setDictCollectionId(pk);
	}

	public long getDictCollectionId() {
		return _dictCollectionId;
	}

	public void setDictCollectionId(long dictCollectionId) {
		_dictCollectionId = dictCollectionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCollectionCode() {
		return _collectionCode;
	}

	public void setCollectionCode(String collectionCode) {
		_collectionCode = collectionCode;
	}

	public String getCollectionName() {
		return _collectionName;
	}

	public void setCollectionName(String collectionName) {
		_collectionName = collectionName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _dictCollectionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _collectionCode;
	private String _collectionName;
	private String _description;
}