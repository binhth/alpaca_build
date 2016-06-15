<%@page import="org.opencps.dossiermgt.service.DossierFileLocalServiceUtil"%>
<%@page import="org.opencps.processmgt.model.WorkflowOutput"%>
<%@page import="org.opencps.processmgt.service.WorkflowOutputLocalServiceUtil"%>
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
	
	List<WorkflowOutput> listESign = WorkflowOutputLocalServiceUtil.getByProcessWFEsign(processWorkflowId, true);
	List<String> listFileToSigner = new ArrayList<String>();
	List<String> listDossierPartToSigner = new ArrayList<String>();
	List<String> listDossierFileToSigner = new ArrayList<String>();
	for (WorkflowOutput workflowOutput : listESign) {
		DossierFile dossierFile2 = DossierFileLocalServiceUtil.getDossierFileInUse(dossierId, workflowOutput.getDossierPartId());
		if(Validator.isNotNull(dossierFile2)){
			listFileToSigner.add(dossierFile2.getFileEntryId()+"");
			listDossierPartToSigner.add(workflowOutput.getDossierPartId()+"");
			listDossierFileToSigner.add(dossierFile2.getDossierFileId()+"");
		}
		
// 		List<DossierFile> listDossier = DossierFileLocalServiceUtil.getDossierFileByD_DP(dossierId, workflowOutput.getDossierPartId());
// 		for (DossierFile dossierFile2 : listDossier) {
// 			listFileToSigner.add(dossierFile2.getFileEntryId()+"");
// 			listDossierPartToSigner.add(workflowOutput.getDossierPartId()+"");
// 			listDossierFileToSigner.add(dossierFile2.getDossierFileId()+"");
// 		}
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
		name="listFileToSigner" 
		value="<%=StringUtil.merge(listFileToSigner) %>" 
		type="hidden"
	/>
	<aui:input 
		name="listDossierPartToSigner" 
		value="<%=StringUtil.merge(listDossierPartToSigner) %>" 
		type="hidden"
	/>
	<aui:input 
		name="listDossierFileToSigner" 
		value="<%=StringUtil.merge(listDossierFileToSigner) %>" 
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
	<c:choose>
		<c:when test="<%=listESign.size() > 0 %>">
			<aui:button type="submit" value="submit" name="submit" />
			<aui:button type="button" value="kySo" name="kySo" onClick="getFileComputerHash(1);"/>
			<aui:button type="button" value="dongdau" name="dongdau" onClick="getFileComputerHash(0);"/>
		</c:when>
		<c:otherwise>
			<aui:button type="submit" value="submit" name="submit" />
		</c:otherwise>
	</c:choose>
	
	<aui:button type="button" value="cancel" name="cancel"/>
</aui:form>
<div style="visibility: hidden; height: 0px; width: 0px;">
	<object id="plugin0" type="application/x-cryptolib05plugin" width="0" height="0" ></object>
</div>

<portlet:resourceURL var="getDataAjax"></portlet:resourceURL>

<portlet:actionURL var="signatureURL" name="signature"></portlet:actionURL>
<aui:script>
function formSubmit() {
	document.getElementById('<portlet:namespace />fm').action = '<%=assignToUserURL.toString() %>';
		document.getElementById('<portlet:namespace />fm').submit();
}
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
	function plugin0()
	 {
	  return document.getElementById('plugin0');
	 }
	 plugin = plugin0;
	var complateSignatureURL = '<%=signatureURL%>';

		function getFileComputerHash(ks) {

			var url = '<%=getDataAjax%>';
			var nanoTime = $('#nanoTimePDF').val();
			
			url = url + "&nanoTimePDF="+nanoTime;
			var listFileToSigner = $("#<portlet:namespace/>listFileToSigner").val().split(","); 
			var listDossierPartToSigner = $("#<portlet:namespace/>listDossierPartToSigner").val().split(","); 
			var listDossierFileToSigner = $("#<portlet:namespace/>listDossierFileToSigner").val().split(","); 
			for ( var i = 0; i < listFileToSigner.length; i++) {
				$.ajax({
					type : 'POST',
					url : url,
					data : {
						<portlet:namespace/>index: i,
						<portlet:namespace/>indexSize: listFileToSigner.length,
						<portlet:namespace/>ks: ks,
						<portlet:namespace/>fileId: listFileToSigner[i],
						<portlet:namespace/>dossierId: $("#<portlet:namespace/>dossierId").val(),
						<portlet:namespace/>dossierPartId: listDossierPartToSigner[i],
						<portlet:namespace/>dossierFileId: listDossierFileToSigner[i],
						<portlet:namespace/>type: 'getComputerHash'
					},
					success : function(data) {
						if(data){
							var jsonData = JSON.parse(data);
							var hashComputers = jsonData.hashComputers;
							var signFieldNames = jsonData.signFieldNames;
							var filePaths = jsonData.filePaths;
							var msgs = jsonData.msg;
							var fileNames = jsonData.fileNames;
							var dossierFileIds = jsonData.dossierFileIds;
							var dossierPartIds = jsonData.dossierPartIds;
							var indexs = jsonData.indexs;
							var indexSizes = jsonData.indexSizes;
							for ( var i = 0; i < hashComputers.length; i++) {
								var hashComputer = hashComputers[i];
								var signFieldName = signFieldNames[i];
								var filePath = filePaths[i];
								var msg = msgs[i];
								var fileName = fileNames[i];
								var dossierFileId = dossierFileIds[i];
								var dossierPartId = dossierPartIds[i];
								var index = indexs[i];
								var indexSize = indexSizes[i];
								if(plugin().valid){
									if(msg === 'success'){
		 								var code = plugin().Sign(hashComputer);
		 								if(code ===0 || code === 7){
		 									var sign = plugin().Signature;
											completeSignature(sign, signFieldName, filePath, fileName, $("#<portlet:namespace/>dossierId").val(), dossierFileId, dossierPartId, index, indexSize, '<%=signatureURL%>');
											
		 								}else{
		 									alert("signer error");
		 					            }
									}else{
										alert(msg);
									}
						        	
						        } else {
						         	alert("Plugin is not working");
						        }
							}
						}
					}
				});
			}
	}

	function completeSignature(sign, signFieldName, filePath, fileName, dossierId, dossierFileId, dossierPartId, index, indexSize, urlFromSubmit) {
		var msg = '';
		var A = AUI();
		A.io.request(
				complateSignatureURL,
				{
				    dataType : 'json',
				    data:{    	
				    	<portlet:namespace/>sign : sign,
						<portlet:namespace/>signFieldName : signFieldName,
						<portlet:namespace/>filePath : filePath,
						<portlet:namespace/>fileName : fileName,
						<portlet:namespace/>dossierId : dossierId,
						<portlet:namespace/>dossierFileId: dossierFileId,
						<portlet:namespace/>dossierPartId : dossierPartId
				    },   
				    on: {
				        success: function(event, id, obj) {
				        	var instance = this;
							var res = instance.get('responseData');
							
							var msg = res.msg;
							var newis = indexSize-1;
								if (msg === 'success') {
									if(index == newis){
										formSubmit();
									}
								} else {
										alert("--------- vao day completeSignature- ky so ko dc-------------");
								}
						},
				    	error: function(){
				    		alert("--------- vao day completeSignature- ky so ko dc-------------");
				    	}
					}
				}
			);
		
	}
	
</aui:script>
