
<%@page import="org.opencps.backend.util.PaymentRequestGenerator"%>
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

<%@page import="org.opencps.util.PortletUtil"%>
<%@page import="org.opencps.util.DateTimeUtil"%>
<%@page import="org.opencps.processmgt.service.ProcessWorkflowLocalServiceUtil"%>
<%@page import="org.opencps.processmgt.model.ProcessWorkflow"%>
<%@page import="java.util.Date"%>
<%@page import="org.opencps.backend.util.BookingDateGenerator"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="org.opencps.processmgt.util.ProcessUtils"%>
<%@page import="org.opencps.processmgt.search.ProcessOrderDisplayTerms"%>
<%@page import="org.opencps.dossiermgt.model.DossierFile"%>
<%@page import="org.opencps.processmgt.model.ProcessOrder"%>
<%@ include file="../init.jsp"%>

<%
	boolean success = false;
	
	try{
		success = !SessionMessages.isEmpty(renderRequest) && SessionErrors.isEmpty(renderRequest);
		
	}catch(Exception e){
		
	}
	ProcessOrder processOrder = (ProcessOrder) request.getAttribute(WebKeys.PROCESS_ORDER_ENTRY);
	
	DossierFile  dossierFile = (DossierFile) request.getAttribute(WebKeys.DOSSIER_FILE_ENTRY);

	long dossierId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.DOSSIER_ID);
	long fileGroupId =  ParamUtil.getLong(request, ProcessOrderDisplayTerms.FILE_GROUP_ID);
	long processOrderId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.PROCESS_ORDER_ID);
	long actionUserId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.ACTION_USER_ID);
	long processWorkflowId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.PROCESS_WORKFLOW_ID);
	long serviceProcessId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.SERVICE_PROCESS_ID);
	long processStepId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.PROCESS_STEP_ID);
	
	String actionNote = ParamUtil.getString(request, ProcessOrderDisplayTerms.ACTION_NOTE);
	String event = ParamUtil.getString(request, ProcessOrderDisplayTerms.EVENT);
	String receptionNo = ParamUtil.getString(request, ProcessOrderDisplayTerms.RECEPTION_NO);
	
	String strReceiveDate = ParamUtil.getString(request, "receiveDate");
	
	String deadlinePattern = ParamUtil.getString(request, "deadlinePattern");
	
	String backURL = ParamUtil.getString(request, "backURL");
	
	Date receiveDate = null;
	
	if(Validator.isNotNull(strReceiveDate)){
		receiveDate = DateTimeUtil.convertStringToDate(strReceiveDate);
	}
	
	Date estimateDate = null;
	
	if(receiveDate != null && Validator.isNotNull(deadlinePattern)){
		estimateDate = BookingDateGenerator.dateGenerator(receiveDate, deadlinePattern);
	}
	
	PortletUtil.SplitDate spd = null;
	
	if(estimateDate != null){
		spd = new PortletUtil.SplitDate(estimateDate);
	}
	
	ProcessWorkflow processWorkflow = null;
	
	if(processWorkflowId > 0){
		try{
			processWorkflow = ProcessWorkflowLocalServiceUtil.getProcessWorkflow(processWorkflowId);
		}catch(Exception e){}
	}
%>

<portlet:actionURL var="assignToUserURL" name="assignToUser"/>

<aui:form name="fm" action="<%=assignToUserURL.toString() %>" method="post">
	<aui:input 
		name="redirectURL" 
		value="<%=currentURL %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.PROCESS_STEP_ID %>" 
		value="<%=processStepId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.GROUP_ID %>" 
		value="<%=scopeGroupId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.COMPANY_ID %>" 
		value="<%=company.getCompanyId() %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.EVENT %>" 
		value="<%=event %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.ACTION_USER_ID %>" 
		value="<%=actionUserId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.DOSSIER_ID %>" 
		value="<%=dossierId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.FILE_GROUP_ID %>" 
		value="<%=fileGroupId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.PROCESS_ORDER_ID %>" 
		value="<%=processOrderId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.PROCESS_WORKFLOW_ID %>" 
		value="<%=processWorkflowId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.SERVICE_PROCESS_ID %>" 
		value="<%=serviceProcessId %>" 
		type="hidden"
	/>
	<aui:input 
		name="backURL"
		value="<%=backURL %>" 
		type="hidden"
	/>
	<aui:select 
		name="<%=ProcessOrderDisplayTerms.ASSIGN_TO_USER_ID %>" 
		label="assign-to-next-user" 
		showEmptyOption="true"
	>
		<%
			List<User> assignUsers = ProcessUtils.getAssignUsers(processStepId);
			for (User userSel : assignUsers) {
		%>	
			<aui:option value="<%= userSel.getUserId() %>"><%= userSel.getFullName() %></aui:option>
		<%
			}
		%>
	</aui:select>
	
	<c:if test="<%=processWorkflow != null &&  processWorkflow.isRequestPayment()%>">
		<aui:input 
			name="<%=ProcessOrderDisplayTerms.PAYMENTVALUE %>" 
			label="requirement-to-pay-charges" 
			type="text"
			value="<%=Validator.isNotNull(processWorkflow.getPaymentFee()) ? PaymentRequestGenerator.getTotalPayment(processWorkflow.getPaymentFee()) : StringPool.BLANK %>"
		/>
	</c:if>
	
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.RECEPTION_NO %>" 
		label="reception-no" 
		value="<%=receptionNo %>"
		type="text"
	/>
	
	<label class="control-label custom-lebel" 
		for='<portlet:namespace/><%="deadline" %>'
	>
		<liferay-ui:message key="return-date"/>
	</label>
		
	<liferay-ui:input-date
		dayParam="<%=ProcessOrderDisplayTerms.ESTIMATE_DATETIME_DAY %>"
		disabled="<%= false %>"
		monthParam="<%=ProcessOrderDisplayTerms.ESTIMATE_DATETIME_MONTH %>"
		name="<%=ProcessOrderDisplayTerms.ESTIMATE_DATETIME %>"
		yearParam="<%=ProcessOrderDisplayTerms.ESTIMATE_DATETIME_YEAR %>"
		formName="fm"
		autoFocus="<%=true %>"
		dayValue="<%=spd != null ? spd.getDayOfMoth() : 0 %>"
		monthValue="<%=spd != null ? spd.getMonth() : 0 %>"
		yearValue="<%=spd != null ? spd.getYear() : 0 %>"
		nullable="<%=spd == null ? true: false %>"
	/>
	
	<aui:input name="<%=ProcessOrderDisplayTerms.ACTION_NOTE %>" label="action-note" type="textarea"/>
	
	<aui:input name="signature" type="checkbox" label="apcept-signature"/>
	<aui:button type="submit" value="submit" name="submit"/>
	<aui:button type="button" value="cancel" name="cancel"/>
</aui:form>

<aui:script>
	AUI().ready(function(A){

		var cancelButton = A.one('#<portlet:namespace/>cancel');
		
		if(cancelButton){
			cancelButton.on('click', function(){
				<portlet:namespace/>closeDialog();
			});
		}
		
		var success = '<%=success%>';
		
		if(success == 'true'){
			var backURL = '<%=backURL%>';
			var Util = Liferay.Util;
			<portlet:namespace/>closeDialog();
			Util.getOpener().Liferay.fire('redirect', {responseData:{backURL:backURL}});
		}
	});
	
	Liferay.provide(window, '<portlet:namespace/>closeDialog', function() {
		var backURL = '<%=backURL%>';
		var dialog = Liferay.Util.getWindow('<portlet:namespace/>assignToUser');
		dialog.destroy();
		Liferay.Util.getOpener().Liferay.Portlet.refresh('#p_p_id_<%= WebKeys.PROCESS_ORDER_PORTLET %>_');
	});
</aui:script>
