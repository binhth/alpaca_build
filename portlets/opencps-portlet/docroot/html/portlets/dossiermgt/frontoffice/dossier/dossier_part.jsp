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
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="org.opencps.dossiermgt.EmptyDossierFileException"%>
<%@page import="org.opencps.dossiermgt.model.Dossier"%>
<%@page import="org.opencps.dossiermgt.model.DossierPart"%>
<%@page import="org.opencps.dossiermgt.model.DossierTemplate"%>
<%@page import="org.opencps.dossiermgt.model.impl.DossierPartImpl"%>
<%@page import="org.opencps.dossiermgt.model.ServiceConfig"%>
<%@page import="org.opencps.dossiermgt.search.DossierFileDisplayTerms"%>
<%@page import="org.opencps.dossiermgt.service.DossierPartLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.util.DossierMgtUtil"%>
<%@page import="org.opencps.servicemgt.model.ServiceInfo"%>
<%@page import="org.opencps.util.PortletConstants"%>
<%@page import="org.opencps.dossiermgt.service.DossierFileLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.DossierFile"%>
<%@page import="org.opencps.dossiermgt.service.FileGroupLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.FileGroup"%>
<%@page import="org.opencps.util.WebKeys"%>
<%@page import="org.opencps.dossiermgt.search.DossierDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ include file="../../init.jsp"%>

<portlet:renderURL 
	var="updateDossierFileURL" 
	windowState="<%=LiferayWindowState.POP_UP.toString() %>"
>
	<portlet:param 
		name="mvcPath" 
		value='<%=templatePath + "upload_dossier_file.jsp" %>'
	/>
</portlet:renderURL>

<liferay-ui:error-marker key="errorSection" value="dossier_part" />

<liferay-ui:error 
	exception="<%= EmptyDossierFileException.class %>" 
	message="<%=EmptyDossierFileException.class.getName() %>"
/>

<%
	Dossier dossier = (Dossier) request.getAttribute(WebKeys.DOSSIER_ENTRY);

	ServiceConfig serviceConfig = (ServiceConfig) request.getAttribute(WebKeys.SERVICE_CONFIG_ENTRY);
	
	ServiceInfo serviceInfo = (ServiceInfo) request.getAttribute(WebKeys.SERVICE_INFO_ENTRY);
	
	DossierTemplate dossierTemplate = (DossierTemplate) request.getAttribute(WebKeys.DOSSIER_TEMPLATE_ENTRY);
	
	String privateDossierGroup = StringPool.BLANK;
	
	List<DossierPart> dossierPartsLevel1 = new ArrayList<DossierPart>();
	
	boolean isEditDossier = true;
	
	if(dossierTemplate != null){
		try{
			dossierPartsLevel1 = DossierPartLocalServiceUtil.getDossierPartsByT_P(dossierTemplate.getDossierTemplateId(), 0);
		}catch(Exception e){}
	}
	
	int index = 0; 
	
	if(dossierPartsLevel1 != null){
		for (DossierPart dossierPartLevel1 : dossierPartsLevel1){
	
			int partType = dossierPartLevel1.getPartType();
			
			List<DossierPart> dossierParts = DossierMgtUtil.getTreeDossierPart(dossierPartLevel1.getDossierpartId());
			
			if(dossierParts != null){
				%>
				<div class="opencps dossiermgt dossier-part-tree" id='<%= renderResponse.getNamespace() + "tree" + dossierParts.get(0).getDossierpartId()%>'>
					<c:choose>
						<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_OPTION ||
							partType == PortletConstants.DOSSIER_PART_TYPE_SUBMIT || 
							partType == PortletConstants.DOSSIER_PART_TYPE_OTHER %>"
						>
							<%
							for(DossierPart dossierPart : dossierParts){
								
								int level = 1;
								
								String treeIndex = dossierPart.getTreeIndex();
								
								if(Validator.isNotNull(treeIndex)){
									level = StringUtil.count(treeIndex, StringPool.PERIOD);
								}
								
								DossierFile dossierFile = null;
								
								if(dossier != null){
									try{
										dossierFile = DossierFileLocalServiceUtil.getDossierFileInUse(dossier.getDossierId(), 
												dossierPart.getDossierpartId());
										
									}catch(Exception e){
										
									}
								}
								
								
								%>
									<div class='<%="opencps dossiermgt dossier-part-row r-" + index%>'>
										<span class='<%="level-" + level + " opencps dossiermgt dossier-part"%>'>
											<span class="row-icon">
												<c:choose>
													<c:when test="<%=(partType == PortletConstants.DOSSIER_PART_TYPE_OPTION ||
														partType == PortletConstants.DOSSIER_PART_TYPE_OTHER) && level == 0%>"
													>
														<i class="fa fa-dot-circle-o" aria-hidden="true"></i>
													</c:when>
													<c:otherwise>
													<i 
														id='<%="rowcheck" + dossierPart.getDossierpartId() + StringPool.DASH + index %>' 
														class='<%=dossierFile != null &&  dossierFile.getFileEntryId() > 0 ? "fa fa-check-square-o" : "fa fa-square-o" %>' 
														aria-hidden="true"
													>
													</i>
													</c:otherwise>
												</c:choose>
												
											</span>
											<span class="opencps dossiermgt dossier-part-name">
												<%=dossierPart.getPartName() %>
											</span>
										</span>
									
										<span class="opencps dossiermgt dossier-part-control">
											<liferay-util:include 
												page="/html/common/portlet/dossier_actions.jsp" 
												servletContext="<%=application %>"
											>
												<portlet:param 
													name="<%=DossierDisplayTerms.DOSSIER_ID %>" 
													value="<%=String.valueOf(dossier != null ? dossier.getDossierId() : 0) %>"
												/>
												<portlet:param 
													name="<%=DossierFileDisplayTerms.DOSSIER_PART_ID %>" 
													value="<%=String.valueOf(dossierPart.getDossierpartId()) %>"
												/>
												<portlet:param 
													name="<%=DossierFileDisplayTerms.FILE_ENTRY_ID %>" 
													value="<%=String.valueOf(dossierFile != null ? dossierFile.getFileEntryId() : 0) %>"
												/>
												<portlet:param 
													name="<%=DossierFileDisplayTerms.DOSSIER_FILE_ID %>" 
													value="<%=String.valueOf(dossierFile != null ? dossierFile.getDossierFileId() : 0) %>"
												/>
												<portlet:param 
													name="<%=DossierFileDisplayTerms.LEVEL %>" 
													value="<%=String.valueOf(level) %>"
												/>
												<portlet:param 
													name="<%=DossierFileDisplayTerms.GROUP_NAME %>" 
													value="<%=StringPool.BLANK%>"
												/>
												<portlet:param 
													name="<%=DossierFileDisplayTerms.PART_TYPE %>" 
													value="<%=String.valueOf(dossierPart.getPartType()) %>"
												/>
											</liferay-util:include>
										</span>
									</div>
								<%
								index++;
							}
							%>
						</c:when>
						
						<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_PRIVATE%>">
							<%
								List<FileGroup> fileGroups = new ArrayList<FileGroup>();
							
								if(dossier != null){
									try{
										fileGroups = FileGroupLocalServiceUtil.getFileGroupByD_DP(dossier.getDossierId(), dossierPartLevel1.getDossierpartId());
									}catch(Exception e){}
								}
								
								
							%>
							<div class='<%="opencps dossiermgt dossier-part-row r-" + index%>'>
								<span class='<%="level-0" + " opencps dossiermgt dossier-part"%>'>
									<span class="row-icon">
										<i class="fa fa-dot-circle-o" aria-hidden="true"></i>
									</span>
									<span class="opencps dossiermgt dossier-part-name">
										<%=dossierPartLevel1.getPartName() %>
									</span>
								</span>
								<span class="opencps dossiermgt dossier-part-control">
									<c:if test="<%=isEditDossier %>">
										<aui:a 
											id="<%=String.valueOf(dossierPartLevel1.getDossierpartId()) %>"
											dossier="<%=String.valueOf(dossier.getDossierId()) %>"
											dossier-part="<%=String.valueOf(dossierPartLevel1.getDossierpartId()) %>"
											href="javascript:void(0);" 
											label="add-private-dossier" 
											cssClass="label opencps dossiermgt part-file-ctr add-individual-part-group"
										/>
									
									</c:if>
								</span>
								<%index++; %>
							</div>
							<c:choose>
								<c:when test="<%=fileGroups != null && ! fileGroups.isEmpty() %>">
									<%
										for(FileGroup fileGroup : fileGroups){
											%>
											<liferay-util:include 
												page="/html/common/portlet/dossier_individual_part.jsp" 
												servletContext="<%=pageContext.getServletContext() %>"
											>
												<portlet:param 
													name="<%=DossierDisplayTerms.DOSSIER_ID %>" 
													value="<%=String.valueOf(dossier != null ? dossier.getDossierId() : 0) %>"
												/>
												<portlet:param 
													name="<%=DossierFileDisplayTerms.DOSSIER_PART_ID %>" 
													value="<%=String.valueOf(fileGroup.getDossierPartId()) %>"
												/>
												
												<portlet:param 
													name="<%=DossierDisplayTerms.FILE_GROUP_ID %>" 
													value="<%=String.valueOf(fileGroup.getFileGroupId()) %>"
												/>
												
												<portlet:param 
													name="<%=DossierFileDisplayTerms.INDEX %>" 
													value="<%=String.valueOf(index) %>"
												/>
												
												<portlet:param 
													name="<%=DossierFileDisplayTerms.GROUP_NAME %>" 
													value="<%=fileGroup.getDisplayName() %>"
												/>
												
												<portlet:param 
													name="isEditDossier" 
													value="<%=String.valueOf(isEditDossier) %>"
												/>
											</liferay-util:include>
											<%
											index ++;
										}
									%>
								</c:when>
								
								<c:otherwise>
									<!--Nothing to show  -->
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<!--Nothing to show  -->
						</c:otherwise>
					</c:choose>
				</div>
				
			<%
			}
		}
	}
	%>
		<aui:input name="curIndex" type="hidden" value="<%=index %>"/>
	<%
%>
<aui:script>
	
	AUI().ready('aui-base','liferay-portlet-url','aui-io', function(A){
		
		//Upload buttons
		var uploadDossierFiles = A.all('.upload-dossier-file');
		
		if(uploadDossierFiles){
			uploadDossierFiles.each(function(e){
				e.on('click', function(){
					var portletURL = Liferay.PortletURL.createURL('<%= PortletURLFactoryUtil.create(request, WebKeys.DOSSIER_MGT_PORTLET, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>');
					portletURL.setParameter("mvcPath", "/html/portlets/dossiermgt/frontoffice/modal_dialog.jsp");
					portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString()%>"); 
					portletURL.setPortletMode("normal");
					portletURL.setParameter("content", "upload-file");
					uploadDossierFile(this, portletURL.toString(), '<portlet:namespace/>');
				});
			});
		}
		
		//View attachment buttons
		var viewAttachments = A.all('.view-attachment');
		
		if(viewAttachments){
			viewAttachments.each(function(e){
				e.on('click', function(){
					var instance = A.one(e);
					var dossierFileId = instance.attr('dossier-file');
					var portletURL = Liferay.PortletURL.createURL('<%= PortletURLFactoryUtil.create(request, WebKeys.DOSSIER_MGT_PORTLET, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE) %>');
					portletURL.setParameter("javax.portlet.action", "previewAttachmentFile");
					portletURL.setParameter("dossierFileId", dossierFileId);
					portletURL.setPortletMode("view");
					portletURL.setWindowState('<%=WindowState.NORMAL%>');
					
					viewDossierAttachment(this, portletURL.toString());
				});
			});
		}
		
		//Remove buttons
		var removeDossierFiles = A.all('.remove-dossier-file');
		
		if(removeDossierFiles){
			removeDossierFiles.each(function(e){
				e.on('click', function(){
					if(confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-remove-dossier-file") %>')){
						
						var instance = A.one(this);
						
						var dossierFileId = instance.attr('dossier-file');
						
						if(parseInt(dossierFileId) > 0){
							var portletURL = Liferay.PortletURL.createURL('<%= PortletURLFactoryUtil.create(request, WebKeys.DOSSIER_MGT_PORTLET, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE) %>');
							portletURL.setParameter("javax.portlet.action", "removeAttachmentFile");
							portletURL.setParameter("dossierFileId", dossierFileId);
							portletURL.setPortletMode("view");
							portletURL.setWindowState('<%=WindowState.NORMAL%>');
							
							A.io.request(
								portletURL.toString(),
								{
									on: {
										success: function(event, id, obj) {
											var response = this.get('responseData');
											if(response){
												response = JSON.parse(response);
												
												if(response.deleted == true){
													Liferay.Util.getOpener().Liferay.Portlet.refresh('#p_p_id_<%= WebKeys.DOSSIER_MGT_PORTLET %>_');
												}else{
													alert('<%= UnicodeLanguageUtil.get(pageContext, "error-while-remove-this-file") %>');
												}
											}
										}
									}
								}
							);
						}
					}
				});
			});	
		}
		
		//Add individual part buttons
		var addIndividualPartGroups = A.all('.add-individual-part-group');
		
		if(addIndividualPartGroups){
			addIndividualPartGroups.each(function(e){
				e.on('click', function(){
					var instance = A.one(e);
					var portletURL = Liferay.PortletURL.createURL('<%= PortletURLFactoryUtil.create(request, WebKeys.DOSSIER_MGT_PORTLET, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>');
					portletURL.setParameter("mvcPath", "/html/portlets/dossiermgt/frontoffice/modal_dialog.jsp");
					portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString()%>"); 
					portletURL.setPortletMode("normal");
					portletURL.setParameter("content", "individual");
					addIndividualPartGroup(this, portletURL.toString(), '<portlet:namespace/>');
				});
			});
		}
		
		//Remove dossier group
		
		var removeIndividualGroups = A.all('.remove-individual-group');
		
		if(removeIndividualGroups){
			removeIndividualGroups.each(function(e){
				e.on('click', function(){
					if(confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-remove-individual-group") %>')){
						
						var instance = A.one(this);
						
						var fileGroupId = instance.attr('file-group');
						var dossierId = instance.attr('dossier');
						var dossierPartId = instance.attr('dossier-part');
						
						if(parseInt(fileGroupId) > 0){
							var portletURL = Liferay.PortletURL.createURL('<%= PortletURLFactoryUtil.create(request, WebKeys.DOSSIER_MGT_PORTLET, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE) %>');
							portletURL.setParameter("javax.portlet.action", "removeIndividualGroup");
							portletURL.setParameter("fileGroupId", fileGroupId);
							portletURL.setParameter("dossierId", dossierId);
							portletURL.setParameter("dossierPartId", dossierPartId);
							portletURL.setPortletMode("view");
							portletURL.setWindowState('<%=WindowState.NORMAL%>');
							
							A.io.request(
								portletURL.toString(),
								{
									on: {
										success: function(event, id, obj) {
											var response = this.get('responseData');
											if(response){
												response = JSON.parse(response);
												
												if(response.deleted == true){
													Liferay.Util.getOpener().Liferay.Portlet.refresh('#p_p_id_<%= WebKeys.DOSSIER_MGT_PORTLET %>_');
												}else{
													alert('<%= UnicodeLanguageUtil.get(pageContext, "error-while-remove-this-group") %>');
												}
											}
										}
									}
								}
							);
						}
					}
				});
			});
		}
	});
	
	
	Liferay.provide(window, '<portlet:namespace/>removeDossierGroup', function(e) {
		if(confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-remove-group") %>')){
			var A = AUI();
			
			var instance = A.one(e);
			
			var dossierPartId = instance.attr('dossier-part');
			
			var index = instance.attr('index');
			
			var groupName = instance.attr('group-name');
			
			var privateDossierPartGroup = A.one('#<portlet:namespace />privateDossierPartGroup' + dossierPartId + '-' + index);
			
			privateDossierPartGroup.remove();
			
			var groupNameIndex = privateDossierGroup.indexOf(groupName);
			
			if (groupNameIndex > -1) {
				privateDossierGroup.splice(groupNameIndex, 1);
			}
		}
	});
	

	
	Liferay.provide(window, '<portlet:namespace/>declarationOnline', function(e) {
		
		var A = AUI();
		
		var instance = A.one(e);
		
		var dossierId = instance.attr('dossier');
		
		var dossierPartId = instance.attr('dossier-part');
		
		var dossierFileId = instance.attr('dossier-file');
		
		var index = instance.attr('index');
		
		var groupName = instance.attr('group-name');

		var portletURL = Liferay.PortletURL.createURL('<%= PortletURLFactoryUtil.create(request, WebKeys.DOSSIER_MGT_PORTLET, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>');
		portletURL.setParameter("mvcPath", "/html/portlets/dossiermgt/frontoffice/dynamic_form.jsp");
		portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString()%>"); 
		portletURL.setPortletMode("normal");
		portletURL.setParameter("dossierPartId", dossierPartId);
		portletURL.setParameter("dossierFileId", dossierFileId);
		portletURL.setParameter("dossierId", dossierId);
		portletURL.setParameter("groupName", groupName);

		<portlet:namespace/>openDossierDialog(portletURL.toString(), '<portlet:namespace />dynamicForm','<%= UnicodeLanguageUtil.get(pageContext, "declaration-online") %>');
	});




</aui:script>
