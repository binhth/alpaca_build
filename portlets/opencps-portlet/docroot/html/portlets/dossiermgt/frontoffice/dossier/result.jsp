<%@page import="org.opencps.dossiermgt.model.impl.DossierFileImpl"%>
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

<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="org.opencps.util.DLFileEntryUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="org.opencps.dossiermgt.service.DossierFileLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.DossierFile"%>
<%@page import="org.opencps.dossiermgt.util.DossierMgtUtil"%>
<%@page import="org.opencps.dossiermgt.service.DossierPartLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.opencps.dossiermgt.model.DossierPart"%>
<%@page import="org.opencps.dossiermgt.model.DossierTemplate"%>
<%@page import="org.opencps.util.WebKeys"%>
<%@page import="org.opencps.dossiermgt.model.Dossier"%>
<%@page import="org.opencps.dossiermgt.service.DossierLogLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.DossierLog"%>
<%@page import="java.util.List"%>
<%@page import="org.opencps.util.DateTimeUtil"%>
<%@page import="org.opencps.util.PortletConstants"%>
<%@ include file="../../init.jsp"%>

<%
	Dossier dossier = (Dossier) request.getAttribute(WebKeys.DOSSIER_ENTRY);
	DossierTemplate dossierTemplate = (DossierTemplate) request.getAttribute(WebKeys.DOSSIER_TEMPLATE_ENTRY);
%>

<c:choose>
	<c:when test="<%=dossier != null && dossier.getDossierStatus() != PortletConstants.DOSSIER_STATUS_NEW %>">
		<%
			String[] actors = new String[]{WebKeys.ACTOR_ACTION_CITIZEN};
			String[] requestCommands = new String[]{WebKeys.ACTION_RESUBMIT_VALUE, WebKeys.ACTION_PAY_VALUE};
			List<DossierLog> dossierLogs = DossierLogLocalServiceUtil.findRequiredProcessDossier(dossier.getDossierId(), actors, requestCommands);
			List<DossierPart> dossierPartsLevel1 = new ArrayList<DossierPart>();
			
			if(dossierTemplate != null){
				try{
					dossierPartsLevel1 = DossierPartLocalServiceUtil.getDossierPartsByT_P_PT(dossierTemplate.getDossierTemplateId(), 0, PortletConstants.DOSSIER_PART_TYPE_RESULT);
				}catch(Exception e){}
			}
		%>
		<aui:row>
			<aui:col width="25">
				<liferay-ui:message key="dossier-create-date"/>
			</aui:col>
			<aui:col width="25">
				<%=DateTimeUtil.convertDateToString(dossier.getCreateDate(), DateTimeUtil._VN_DATE_TIME_FORMAT) %>
			</aui:col>
			<aui:col width="25">
				<liferay-ui:message key="dossier-submit-date"/>
			</aui:col>
			<aui:col width="25">
				<%=DateTimeUtil.convertDateToString(dossier.getSubmitDatetime(), DateTimeUtil._VN_DATE_TIME_FORMAT) %>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="25">
				<liferay-ui:message key="dossier-receive-date"/>
			</aui:col>
			<aui:col width="25">
				<%=DateTimeUtil.convertDateToString(dossier.getReceiveDatetime(), DateTimeUtil._VN_DATE_TIME_FORMAT) %>
			</aui:col>
			<aui:col width="25">
				<liferay-ui:message key="dossier-reception-no"/>
			</aui:col>
			<aui:col width="25">
				<%=dossier.getReceptionNo() %>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="25">
				<liferay-ui:message key="dossier-estimate-date"/>
			</aui:col>
			<aui:col width="25">
				<%=DateTimeUtil.convertDateToString(dossier.getEstimateDatetime(), DateTimeUtil._VN_DATE_TIME_FORMAT) %>
			</aui:col>
			<aui:col width="25">
				<liferay-ui:message key="dossier-finish-date"/>
			</aui:col>
			<aui:col width="25">
				<%=DateTimeUtil.convertDateToString(dossier.getFinishDatetime(), DateTimeUtil._VN_DATE_TIME_FORMAT) %>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="25">
				<liferay-ui:message key="dossier-update-date"/>
			</aui:col>
			<aui:col width="25"></aui:col>
			<aui:col width="25">
				<liferay-ui:message key="log-status"/>
			</aui:col>
			<aui:col width="25"></aui:col>
		</aui:row>
		<hr class="canbo-ket-qua">
		<c:if test="<%=dossierLogs != null && !dossierLogs.isEmpty() %>">
			<aui:row>
				<label>
					<liferay-ui:message key="required-process"/>
				</label>
				<table class="process-workflow-info">
					<tr class="odd">
						<td width="10%"><liferay-ui:message key="number-order"/></td>
						<td width="30%"><liferay-ui:message key="datetime"/></td>
						<td width="30%"><liferay-ui:message key="request-command"/></td>
						<td width="30%"><liferay-ui:message key="message-info"/></td>
					</tr>
					<%
						for(DossierLog dossierLog : dossierLogs){
							%>
								<tr class="odd">
									<td>
										<%=dossierLogs.indexOf(dossierLog) %>
									</td>
									<td>
										<%=dossierLog.getUserUuid() != null ? 
												DateTimeUtil.convertDateToString(dossierLog.getUpdateDatetime(), DateTimeUtil._VN_DATE_TIME_FORMAT) : 
												StringPool.BLANK 
										%>
									</td>
									<td>
										<%=dossierLog.getRequestCommand() %>
									</td>
									<td>
										<%=dossierLog.getMessageInfo() %>
									</td>
								</tr>
							<%
						}
					%>
				</table>
			</aui:row>
		</c:if>
		<%
		if(dossierPartsLevel1 != null){
			%>
				<table class="process-workflow-info">
					<tr class="odd">
						<td width="10%" bordercolor="#ccc"><liferay-ui:message key="number-order"/></td>
						<td width="30%" bordercolor="#ccc"><liferay-ui:message key="dossier-file-date"/></td>
						<td width="30%" bordercolor="#ccc"><liferay-ui:message key="dossier-file-no"/></td>
						<td width="30%" bordercolor="#ccc"><liferay-ui:message key="dossier-file-name"/></td>
					</tr>
					<%
					int count = 1;
					for (DossierPart dossierPartLevel1 : dossierPartsLevel1){
						
						int partType = dossierPartLevel1.getPartType();
					
						List<DossierPart> dossierParts = DossierMgtUtil.getTreeDossierPart(dossierPartLevel1.getDossierpartId());
						
						if(dossierParts != null){
							for(DossierPart dossierPart : dossierParts){
								DossierFile dossierFile = null;
								try{
									dossierFile = DossierFileLocalServiceUtil.getDossierFileInUse(dossier.getDossierId(), dossierPart.getDossierpartId());
									if(Validator.isNull(dossierFile)){
										dossierFile = new DossierFileImpl();
									}
								}catch(Exception e){
									continue;
								}
								
								if(dossierFile.getFileEntryId() <= 0 || dossierFile.getSyncStatus() != PortletConstants.DOSSIER_FILE_SYNC_STATUS_SYNCSUCCESS){
									continue;
								}
								
								
								String fileURL = StringPool.BLANK;
								
								try{
									FileEntry fileEntry = DLFileEntryUtil.getFileEntry(dossierFile.getFileEntryId());
									if(fileEntry != null){
										fileURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), 
												themeDisplay, StringPool.BLANK);
									}
								}catch(Exception e){
									continue;
									
								}
								
								%>
									<tr class="odd">
										<td><%=count %></td>
										<td>
											<%=Validator.isNotNull(dossierFile.getDossierFileDate()) ? DateTimeUtil.convertDateToString(dossierFile.getDossierFileDate(), DateTimeUtil._VN_DATE_TIME_FORMAT) : StringPool.BLANK %>
										</td>
										<td>
											<%=Validator.isNotNull(dossierFile.getDossierFileNo()) ? dossierFile.getDossierFileNo() : StringPool.BLANK %>
										</td>
										<td>
											<a class="label opencps dossiermgt part-file-ctr" href="<%=fileURL%>" target="_blank">
												<%=Validator.isNotNull(dossierFile.getDisplayName()) ? dossierFile.getDisplayName() : StringPool.BLANK  %>
											</a>
										</td>
									</tr>
								<%
								
								count++;
							}
						}
					}
					%>
				</table>
			<%
		}
		%>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-info">
			<liferay-ui:message key="no-dossier-result-info"/>
		</div>
	</c:otherwise>
</c:choose>
<style>
#_13_WAR_opencpsportlet_result .row-fluid {
    border-left: 1px solid gainsboro;
	border-top: 1px solid gainsboro;
	border-bottom: 1px solid gainsboro;
	border-right: 0px solid gainsboro;
    margin-top: -1px;
}
#_13_WAR_opencpsportlet_result .row-fluid .span3 {
    padding-left: 10px;
    border-right: 1px solid gainsboro;
    padding-top: 5px;
}
.odd{
padding: 10px;
 border-left: 1px solid gainsboro;
  border-top: 1px solid gainsboro;
   border-bottom: 1px solid gainsboro;
    border-right: 0px solid gainsboro;
}
.odd td{
border-right: 1px solid gainsboro;
padding: 5px 0px 5px 10px;
}
.process-workflow-info{
width: 100%;
}
.process-workflow-info .label.opencps.dossiermgt.part-file-ctr{
	width: 100%;
	text-align: center;
	margin-right: 2px;
}
</style>