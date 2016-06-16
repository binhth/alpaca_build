<%@page import="org.opencps.processmgt.search.ProcessOrderDisplayTerms"%>
<%@page import="org.opencps.processmgt.model.ProcessOrder"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
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

<%@ include file="../init.jsp"%>
<%
	ResultRow row =	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ProcessOrder processOrder = (ProcessOrder)row.getObject();	
%>

<portlet:renderURL var="dossierReturn">
	<portlet:param name="<%= ProcessOrderDisplayTerms.PROCESS_ORDER_ID %>"
		value="<%=String.valueOf(processOrder.getProcessOrderId()) %>" />
	<portlet:param name="mvcPath"
		value="/html/portlets/processmgt/onegate/dossierreturn.jsp" />
	<portlet:param name="redirectURL" value="<%= currentURL %>" />
	<portlet:param name="backURL" value="<%=currentURL %>"/>
	
</portlet:renderURL>

<a href="<%= dossierReturn.toString() %>">
	<liferay-ui:message key="dossier-return"></liferay-ui:message>
</a>