<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="org.opencps.processmgt.util.ProcessMgtUtil"%>
<%@page import="org.opencps.dossiermgt.util.DossierMgtUtil"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>
<%@page import="org.opencps.dossiermgt.service.DossierFileLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.DossierFile"%>
<%@page import="org.opencps.util.DateTimeUtil"%>
<%@page import="org.opencps.processmgt.NoSuchProcessOrderException"%>
<%@page import="org.opencps.processmgt.service.ProcessOrderLocalServiceUtil"%>
<%@page import="org.opencps.processmgt.search.ProcessOrderDisplayTerms"%>
<%@page import="org.opencps.processmgt.model.ProcessOrder"%>
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
<liferay-util:include page="/html/portlets/processmgt/onegate/toptabs.jsp" servletContext="<%=application %>" />

<%
	long processOrderId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.PROCESS_ORDER_ID);
	ProcessOrder processOrder = null;
	try {
		processOrder = ProcessOrderLocalServiceUtil.getProcessOrder(processOrderId);
	}
	catch (NoSuchProcessOrderException e) {
		
	}
	Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
	String message = "";
	if (processOrder != null) {
		String successMessage = LanguageUtil.get(pageContext, "dossier-return-success-with-action-datetime");
		message = String.format(locale, successMessage, DateTimeUtil.convertDateToString(processOrder.getActionDatetime(), DateTimeUtil._VN_DATE_TIME_FORMAT));
	}
%>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath"
		value="/html/portlets/processmgt/onegate/dossierlist.jsp" />	
	<portlet:param name="tabs1"
		value="<%= ProcessMgtUtil.TOP_TABS_ONEGATE_RETURNLIST %>" />			
</portlet:renderURL>

<liferay-ui:header
	backURL="<%= backURL.toString() %>"
	title="dossier-return-list"
	backLabel="back"
/>
<c:if test="<%= processOrder != null %>">
	<span><%= message %></span>
</c:if>
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
<c:if test="<%= processOrder != null %>">
<%
	List<PaymentFile> lsPaymentFiles = new ArrayList<PaymentFile>();
	try {
		lsPaymentFiles = PaymentFileLocalServiceUtil.getPaymentFileByD_(processOrder.getDossierId());
	}
	catch (SystemException e) {
		
	}
	if (lsPaymentFiles.size() > 0) {
%>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>
				<liferay-ui:message key="payment-name"></liferay-ui:message>
			</th>
			<th>
				<liferay-ui:message key="amount"></liferay-ui:message>
			</th>
			<th>
				<liferay-ui:message key="confirm-note"></liferay-ui:message>
			</th>			
		</tr>
	</thead>
	<tbody>
		<%
			for (int i = 0; i < lsPaymentFiles.size(); i++) {
		%>
			<tr>
				<td><%= lsPaymentFiles.get(i).getPaymentName() %></td>
				<td><%= NumberFormat.getInstance(new Locale("vi","VN")).format(lsPaymentFiles.get(i).getAmount()) %></td>
				<td><%= lsPaymentFiles.get(i).getApproveNote() %></td>
			</tr>
		<%
			}
		%>
	</tbody>
</table>
<%
	}
%>