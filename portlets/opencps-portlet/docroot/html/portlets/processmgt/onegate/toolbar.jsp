<%@page import="org.opencps.servicemgt.service.ServiceInfoLocalServiceUtil"%>
<%@page import="org.opencps.processmgt.search.ProcessOrderDisplayTerms"%>
<%@page import="org.opencps.processmgt.util.ProcessMgtUtil"%>
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

<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../init.jsp"%>

<%
	PortletURL searchURL = renderResponse.createRenderURL();	

	String tabs1 = ParamUtil.getString(request, "tabs1", ProcessMgtUtil.TOP_TABS_ONEGATE_DOSSIERLIST);
	int serviceInfoId = ParamUtil.getInteger(request, ProcessOrderDisplayTerms.SERVICE_INFO_ID, -1);
%>

<aui:nav-bar cssClass="custom-toolbar">
	<aui:nav id="toolbarContainer" cssClass="nav-display-style-buttons pull-left" >
		
	</aui:nav>
	<c:choose>
		<c:when test="<%= tabs1.equals(ProcessMgtUtil.TOP_TABS_ONEGATE_DOSSIERLIST)%>">
	
		</c:when>
		<c:when test="<%= tabs1.equals(ProcessMgtUtil.TOP_TABS_ONEGATE_RETURNLIST)%>">
			<%
				searchURL.setParameter("tabs1", ProcessMgtUtil.TOP_TABS_ONEGATE_RETURNLIST);
				searchURL.setParameter("mvcPath", templatePath + "returnlist.jsp");
			%>
				<aui:nav-bar-search cssClass="pull-left" style="width: 98%;">
					<div class="form-search">
						<aui:form action="<%= searchURL %>" method="post" name="fm">
							<div class="toolbar_search_input">
								<aui:row>
									<aui:col width="30">
										<aui:select label="" name="domainId" style="width: 100%;">
											<aui:option value="<%= ProcessMgtUtil.SERVICEINFO_ALL %>">
												<liferay-ui:message key="filter-by-domain"></liferay-ui:message>
											</aui:option>
										</aui:select>						
									</aui:col>
									<aui:col width="30">
										<aui:select label="" name="<%= ProcessOrderDisplayTerms.SERVICE_INFO_ID %>" style="width: 100%;">
											<aui:option value="<%= ProcessMgtUtil.SERVICEINFO_ALL %>">
												<liferay-ui:message key="filter-by-serviceinfo"></liferay-ui:message>
											</aui:option>
											<%
												List<ServiceInfo> lsServiceInfo = ServiceInfoLocalServiceUtil.getServiceInfos(0, ServiceInfoLocalServiceUtil.getServiceInfosCount());
												for (ServiceInfo serviceInfo : lsServiceInfo) {
													if (serviceInfoId == serviceInfo.getServiceinfoId()) {
											%>
											<aui:option selected="true" value="<%= serviceInfo.getServiceinfoId() %>"><%= serviceInfo.getServiceName() %></aui:option>
											<%
													}
													else {
											%>
											<aui:option selected="false" value="<%= serviceInfo.getServiceinfoId() %>"><%= serviceInfo.getServiceName() %></aui:option>
											<% 
													}
												}
											%>
										</aui:select>						
									</aui:col>
									<aui:col width="30">
										<liferay-ui:input-search 
											id="keywords"
											name="keywords"
											title='<%= LanguageUtil.get(portletConfig, locale, "keywords") %>'
											placeholder="<%= LanguageUtil.get(portletConfig, locale, \"keywords\") %>" 
										/>
									</aui:col>
								</aui:row>
							</div>
						</aui:form>
					</div>			
				</aui:nav-bar-search>
		</c:when>
	</c:choose>
</aui:nav-bar>
<%!
	private Log _log = LogFactoryUtil.getLog("html.portlets.processmgt.onegate.toolbar.jsp");
%>