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

package com.dict.dao.model.impl;

import com.dict.dao.model.DictCollectionAlpacaJS;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DictCollectionAlpacaJS in entity cache.
 *
 * @author binhth
 * @see DictCollectionAlpacaJS
 * @generated
 */
public class DictCollectionAlpacaJSCacheModel implements CacheModel<DictCollectionAlpacaJS>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{dictCollectionId=");
		sb.append(dictCollectionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", collectionCode=");
		sb.append(collectionCode);
		sb.append(", collectionName=");
		sb.append(collectionName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DictCollectionAlpacaJS toEntityModel() {
		DictCollectionAlpacaJSImpl dictCollectionAlpacaJSImpl = new DictCollectionAlpacaJSImpl();

		dictCollectionAlpacaJSImpl.setDictCollectionId(dictCollectionId);
		dictCollectionAlpacaJSImpl.setCompanyId(companyId);
		dictCollectionAlpacaJSImpl.setGroupId(groupId);
		dictCollectionAlpacaJSImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dictCollectionAlpacaJSImpl.setCreateDate(null);
		}
		else {
			dictCollectionAlpacaJSImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dictCollectionAlpacaJSImpl.setModifiedDate(null);
		}
		else {
			dictCollectionAlpacaJSImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (collectionCode == null) {
			dictCollectionAlpacaJSImpl.setCollectionCode(StringPool.BLANK);
		}
		else {
			dictCollectionAlpacaJSImpl.setCollectionCode(collectionCode);
		}

		if (collectionName == null) {
			dictCollectionAlpacaJSImpl.setCollectionName(StringPool.BLANK);
		}
		else {
			dictCollectionAlpacaJSImpl.setCollectionName(collectionName);
		}

		if (description == null) {
			dictCollectionAlpacaJSImpl.setDescription(StringPool.BLANK);
		}
		else {
			dictCollectionAlpacaJSImpl.setDescription(description);
		}

		dictCollectionAlpacaJSImpl.resetOriginalValues();

		return dictCollectionAlpacaJSImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dictCollectionId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		collectionCode = objectInput.readUTF();
		collectionName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dictCollectionId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (collectionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionCode);
		}

		if (collectionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long dictCollectionId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String collectionCode;
	public String collectionName;
	public String description;
}