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
import com.dict.dao.service.DictCollectionAlpacaJSLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the DictCollectionAlpacaJS service. Represents a row in the &quot;opencps_dictcollection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DictCollectionAlpacaJSImpl}.
 * </p>
 *
 * @author binhth
 * @see DictCollectionAlpacaJSImpl
 * @see com.dict.dao.model.DictCollectionAlpacaJS
 * @generated
 */
public abstract class DictCollectionAlpacaJSBaseImpl
	extends DictCollectionAlpacaJSModelImpl implements DictCollectionAlpacaJS {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dict collection alpaca j s model instance should use the {@link DictCollectionAlpacaJS} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DictCollectionAlpacaJSLocalServiceUtil.addDictCollectionAlpacaJS(this);
		}
		else {
			DictCollectionAlpacaJSLocalServiceUtil.updateDictCollectionAlpacaJS(this);
		}
	}
}