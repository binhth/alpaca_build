<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.dict.dao.service.DictCollectionAlpacaJSLocalServiceUtil"%>
<%@page import="com.dict.dao.model.DictCollectionAlpacaJS"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%
	/**
	 * OpenCPS is the open source Core Public Services software
	 * Copyright (C) 2016-present OpenCPS community
	 * 
	 * This program is free software: you can redistribute it and/or modify
	 * it under the terms of the GNU Affero General Public License as published by
	 * the Free Software Foundation, either version 3 of the License, or
	 * any later version.
	 * 
	 * This program is distributed in the hope that it will be useful,
	 * but WITHOUT ANY WARRANTY; without even the implied warranty of
	 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
	 * GNU Affero General Public License for more details.
	 * You should have received a copy of the GNU Affero General Public License
	 * along with this program. If not, see <http://www.gnu.org/licenses/>.
	 */
%>

<%@ include file="/init.jsp"%>

<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>


 <liferay-ui:search-container emptyResultsMessage="there-are-no-collection"
headerNames="code, name, tool"
> 
<liferay-ui:search-container-results>
		<%
		pageContext.setAttribute("results", DictCollectionAlpacaJSLocalServiceUtil.getDictCollectionAlpacaJSs(QueryUtil.ALL_POS, QueryUtil.ALL_POS));// findByGroupId(themeDisplay.getScopeGroupId()));
        pageContext.setAttribute("total", DictCollectionAlpacaJSLocalServiceUtil.getDictCollectionAlpacaJSsCount());
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.dict.dao.model.DictCollectionAlpacaJS" keyProperty="dictCollectionId"
		modelVar="dictCollection">

		<liferay-ui:search-container-column-text 
			name="id"
			value='<%=String.valueOf(dictCollection.getDictCollectionId()) %>' />
		<liferay-ui:search-container-column-text 
            name="name"
            value='<%=dictCollection.getCollectionName() %>' />
		<liferay-ui:search-container-column-text>
		  <input type="button" name="pick" value="pick" onclick="bildDataSelection('<%=dictCollection.getDictCollectionId() %>')" />
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<aui:script use="aui-node">
var Util = Liferay.Util;
    Liferay.provide(window,'bildDataSelection',
         function(id) {
          var A = AUI();
          Liferay.Util.getOpener().updateDataFromPopUp(id);
          Util.getWindow().hide();
  });
</aui:script>