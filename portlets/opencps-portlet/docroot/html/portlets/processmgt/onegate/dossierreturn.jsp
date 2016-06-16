<%@page import="org.opencps.dossiermgt.util.DossierMgtUtil"%>
<%@page import="org.opencps.dossiermgt.service.DossierFileLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.DossierFile"%>
<%@page import="org.opencps.servicemgt.NoSuchServiceInfoException"%>
<%@page import="org.opencps.servicemgt.service.ServiceInfoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>
<%@page import="org.opencps.dossiermgt.NoSuchDossierException"%>
<%@page import="org.opencps.dossiermgt.service.DossierLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.Dossier"%>
<%@page import="org.opencps.processmgt.NoSuchProcessOrderException"%>
<%@page import="org.opencps.processmgt.service.ProcessOrderLocalServiceUtil"%>
<%@page import="org.opencps.processmgt.model.ProcessOrder"%>
<%@page import="org.opencps.processmgt.search.ProcessOrderDisplayTerms"%>
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
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */
%>
<%@ include file="../init.jsp"%>
<%
	long processOrderId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.PROCESS_ORDER_ID);
	ProcessOrder processOrder = null;
	try {
		processOrder = ProcessOrderLocalServiceUtil.getProcessOrder(processOrderId);
	}
	catch (NoSuchProcessOrderException e) {
		
	}
	Dossier dossier = null;
	try {
		if (processOrder != null)
			dossier = DossierLocalServiceUtil.getDossier(processOrder.getDossierId());
	}
	catch (NoSuchDossierException e) {
		
	}
	ServiceInfo serviceInfo = null;
	try {
		if (processOrder != null)
			serviceInfo = ServiceInfoLocalServiceUtil.getServiceInfo(processOrder.getServiceInfoId());
	}
	catch (NoSuchServiceInfoException e) {
		
	}
	Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);	
%>

<aui:row>
	<aui:col width="50">
		<span>
			<liferay-ui:message key="reception-no"></liferay-ui:message>
		</span>
		: 
		<%= dossier != null ? dossier.getReceptionNo() : StringPool.BLANK %>
	</aui:col>
	<aui:col width="50">
		<span>
			<liferay-ui:message key="receive-datetime"></liferay-ui:message>
		</span>
		: 
		<%= (dossier != null && dossier.getReceiveDatetime() != null) ? dateFormatDate.format(dossier.getReceiveDatetime()) : StringPool.BLANK %>
	</aui:col>	
</aui:row>
<aui:row>
	<aui:col width="50">
		<span>
			<liferay-ui:message key="serviceinfo-name">
			</liferay-ui:message>
		</span>
		:
		<%= serviceInfo != null ? serviceInfo.getServiceName() : StringPool.BLANK %>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col width="50">
		<span>
			<liferay-ui:message key="subject-name">
			</liferay-ui:message>
		</span>
		:
		<%= dossier != null ? dossier.getSubjectName() : StringPool.BLANK %>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col width="50">
		<span>
			<liferay-ui:message key="address">
			</liferay-ui:message>
		</span>
		:
		<%= dossier != null ? dossier.getAddress() : StringPool.BLANK %>
	</aui:col>
</aui:row>
<c:if test="<%= processOrder != null %>">
<%
	List<DossierFile> lsFiles = DossierFileLocalServiceUtil.getDossierFileByD_DFT(processOrder.getDossierId(), DossierMgtUtil.DOSSIERFILETYPE_OUTPUT);
	if (lsFiles.size() > 0) {
%>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>
				<liferay-ui:message key="no"></liferay-ui:message>
			</th>
			<th>
				<liferay-ui:message key="dossier-file-no"></liferay-ui:message>
			</th>
			<th>
				<liferay-ui:message key="dossier-file-date"></liferay-ui:message>
			</th>			
			<th>
				<liferay-ui:message key="dossier-file-display-name"></liferay-ui:message>
			</th>
		</tr>
	</thead>
	<tbody>
		<%
			for (int i = 0; i < lsFiles.size(); i++) {
		%>
			<tr>
				<th><%= i + 1 %></th>
				<td><%= lsFiles.get(i).getDossierFileNo() %></td>
				<td><%= lsFiles.get(i).getDossierFileDate() != null ? dateFormatDate.format(lsFiles.get(i).getDossierFileDate()) : StringPool.BLANK %></td>
				<td><%= lsFiles.get(i).getDisplayName() %></td>
			</tr>
		<%
			}
		%>
	</tbody>
</table>
<%
	}
%>
</c:if>
