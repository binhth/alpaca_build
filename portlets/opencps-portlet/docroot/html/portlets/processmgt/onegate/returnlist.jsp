<%@page import="org.opencps.processmgt.util.ProcessMgtUtil"%>
<%@page import="org.opencps.servicemgt.service.ServiceInfoLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.NoSuchDossierException"%>
<%@page import="org.opencps.dossiermgt.service.DossierLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.Dossier"%>
<%@page import="org.opencps.util.PortletConstants"%>
<%@page import="org.opencps.processmgt.service.ProcessOrderLocalServiceUtil"%>
<%@page import="org.opencps.processmgt.search.ProcessOrderSearchTerms"%>
<%@page import="org.opencps.processmgt.search.ProcessOrderSearch"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>
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
<liferay-util:include page="/html/portlets/processmgt/onegate/toptabs.jsp" servletContext="<%=application %>" />
<liferay-util:include page="/html/portlets/processmgt/onegate/toolbar.jsp" servletContext="<%=application %>" />
<%
	long serviceInfoId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.SERVICE_INFO_ID, -1);
	request.setAttribute(ProcessOrderDisplayTerms.SERVICE_INFO_ID, serviceInfoId);
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", templatePath + "returnlist.jsp");
	iteratorURL.setParameter("tabs1", ProcessMgtUtil.TOP_TABS_ONEGATE_RETURNLIST);
	
	List<String> headerNames = new ArrayList<String>();
	
	headerNames.add("no");
	headerNames.add("action-datetime");
	headerNames.add("reception-no");
	headerNames.add("subject-name");
	headerNames.add("serviceinfo-name");
	headerNames.add("action");
	
	String headers = StringUtil.merge(headerNames, StringPool.COMMA);
	Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
%>

<liferay-ui:search-container searchContainer="<%= new ProcessOrderSearch(renderRequest, SearchContainer.DEFAULT_DELTA, iteratorURL) %>" 
	headerNames="<%= headers %>">
		
	<liferay-ui:search-container-results>
		<%
			ProcessOrderSearchTerms searchTerms = (ProcessOrderSearchTerms) searchContainer.getSearchTerms();
						
			total =  (int)ProcessOrderLocalServiceUtil.oneGateCountProcessOrder(scopeGroupId, searchTerms.getKeywords(), PortletConstants.DOSSIER_STATUS_DONE, serviceInfoId, 0);

			results = ProcessOrderLocalServiceUtil.oneGateSearchProcessOrder(scopeGroupId, searchTerms.getKeywords(), 
					PortletConstants.DOSSIER_STATUS_DONE, serviceInfoId, 0, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
		
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row 
		className="org.opencps.processmgt.model.ProcessOrder" 
		modelVar="processOrder" 
		keyProperty="processOrderId"
	>
		<%			
			PortletURL viewURL = renderResponse.createRenderURL();
			viewURL.setParameter("dossierId", String.valueOf(processOrder.getDossierId()));
			viewURL.setParameter("backURL", currentURL);

			// no column
			row.addText(String.valueOf(row.getPos() + 1), viewURL);		
		
			// action datetime column
			if (Validator.isNotNull(processOrder.getActionDatetime())) {
				row.addText(dateFormatDate.format(processOrder.getActionDatetime()));				
			}
			else {
				row.addText(StringPool.BLANK);
			}
			
			Dossier dossier = null;
			try {
				dossier = DossierLocalServiceUtil.getDossier(processOrder.getDossierId());
			}
			catch (NoSuchDossierException e) {
				
			}
			
			// reception no column
			row.addText(dossier != null ? dossier.getReceptionNo() : StringPool.BLANK, viewURL);
			
			// subjectname column
			row.addText(dossier != null ? dossier.getSubjectName() : StringPool.BLANK);
			
			// serviceinfo name column
			ServiceInfo serviceInfo = ServiceInfoLocalServiceUtil.getServiceInfo(processOrder.getServiceInfoId());
			row.addText(serviceInfo != null ? serviceInfo.getServiceName() : StringPool.BLANK);	
			
			row.addJSP(
				    "center",
				    SearchEntry.DEFAULT_VALIGN,
				    "/html/portlets/processmgt/onegate/returnlist_actions.jsp",
				    config.getServletContext(), request, response);
			
		%>	
	
	</liferay-ui:search-container-row>	

	<liferay-ui:search-iterator/>

</liferay-ui:search-container>
