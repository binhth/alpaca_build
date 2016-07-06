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
<%@ page contentType="text/html; charset=UTF-8" %>

<%
String alpacaSchema = (String)request.getSession().getAttribute("alpacaSchema");
String jasperInit = (String)request.getSession().getAttribute("jasperInit");
String sampleData = (String)request.getSession().getAttribute("sampleData");
String auTock = AuthTokenUtil.getToken(request);
%>

<aui:input type="hidden" name="alpacaSchemaF" value="<%=alpacaSchema %>" />
<aui:input type="hidden" name="jasperInitF" value="<%=jasperInit %>" />
<aui:input type="hidden" name="sampleDataF" value="<%=sampleData %>" />
<liferay-ui:tabs
    names="View, Source, JasperReport, SampleData"
    refresh="<%= false %>"
>
    <liferay-ui:section>
        <aui:fieldset id="dynamicForm"></aui:fieldset>
    </liferay-ui:section>
    <liferay-ui:section>
        <div id="editorFinal" class="editor"></div>
    </liferay-ui:section>
     <liferay-ui:section>
        <div id="editorFinalJasper" class="editor2"></div>
    </liferay-ui:section>
    <liferay-ui:section>
        <div id="editorSampleData" class="editor2"></div>
        <table class="table">
            <tbody>
                <tr>
                    <td>
                        _subjectName
                    </td>
                    <td>
                        tên cá nhân, tổ chức làm thủ tục hành chính
                    </td>
                </tr>
                <tr>
                    <td>
                        _subjectId
                    </td>
                    <td>
                        mã cá nhân, tổ chức 
                    </td>
                </tr>
                <tr>
                    <td>
                        _address:
                    </td>
                    <td>
                        địa chỉ liên lạc
                    </td>
                </tr>
                <tr>
                    <td>
                        _cityCode
                    </td>
                    <td>
                        mã thành phố
                    </td>
                </tr>
                <tr>
                    <td>
                        _cityName
                    </td>
                    <td>
                        tên thành phố
                    </td>
                </tr>
                <tr>
                    <td>
                        _districtCode
                    </td>
                    <td>
                        mã quận
                    </td>
                </tr>
                <tr>
                    <td>
                        _districtName
                    </td>
                    <td>
                        tên quận
                    </td>
                </tr>
                <tr>
                    <td>
                        _wardCode
                    </td>
                    <td>
                        mã phường
                    </td>
                </tr>
                <tr>
                    <td>
                        _wardName
                    </td>
                    <td>
                        tên phường
                    </td>
                </tr>
                <tr>
                    <td>
                        _contactName
                    </td>
                    <td>
                        tên người liên lạc
                    </td>
                </tr>
                <tr>
                    <td>
                        _contactTelNo
                    </td>
                    <td>
                        số điện thoại liên lạc
                    </td>
                </tr>
                <tr>
                    <td>
                        _contactEmail
                    </td>
                    <td>
                        địa chỉ email
                    </td>
                </tr>
                <tr>
                    <td>
                        _ngayNopDon
                    </td>
                    <td>
                        Ngày hiện tại
                    </td>
                </tr>
            </tbody>
        </table>
    </liferay-ui:section>
</liferay-ui:tabs>

<aui:script>
	var editor = ace.edit("editorFinal");
	editor.setTheme("ace/theme/github");
	editor.session.setMode("ace/mode/javascript");
	var editorJasper = ace.edit("editorFinalJasper");
	editorJasper.setTheme("ace/theme/github");
	editorJasper.session.setMode("ace/mode/javascript");
	var editorSampleData = ace.edit("editorFinalJasper");
	editorSampleData.setTheme("ace/theme/github");
	editorSampleData.session.setMode("ace/mode/xml");
	var formData = '';
	
	AUI().ready(function(A){
// 		alert(A.one("#<portlet:namespace />alpacaSchemaF").val());
		var editorFinal = ace.edit("editorFinal");
        var myObject = eval('(' + A.one("#<portlet:namespace />alpacaSchemaF").val() + ')');
        editorFinal.setValue(JSON.stringify(myObject, null, 4), -1);
       
        var editorFinalJasper = ace.edit("editorFinalJasper");
        editorFinalJasper.setValue(A.one("#<portlet:namespace />jasperInitF").val());
        
        var editorSampleData = ace.edit("editorSampleData");
        editorSampleData.setValue(formatXml(A.one("#<portlet:namespace />sampleDataF").val()));
        
		var el = $("#<portlet:namespace/>dynamicForm");
		
		Alpaca(el, myObject);
		
	});
	
</aui:script>

<script type="text/javascript">
function formatXml(xml) {
    var formatted = '';
    var reg = /(>)(<)(\/*)/g;
    xml = xml.replace(reg, '$1\r\n$2$3');
    var pad = 0;
    jQuery.each(xml.split('\r\n'), function(index, node)
    {
        var indent = 0;
        if (node.match( /.+<\/\w[^>]*>$/ ))
        {
            indent = 0;
        }
        else if (node.match( /^<\/\w/ ))
        {
            if (pad != 0)
            {
                pad -= 1;
            }
        }
        else if (node.match( /^<\w[^>]*[^\/]>.*$/ ))
        {
            indent = 1;
        }
        else
        {
            indent = 0;
        }
        var padding = '';
        for (var i = 0; i < pad; i++)
        {
            padding += '  ';
        }
        formatted += padding + node + '\r\n';
        pad += indent;
    });
    return formatted;
}
function openCPSSelectedTextValue(id) {
	var listbox = document.getElementById(id);
	var selIndex = listbox.selectedIndex;
	var selText = listbox.options[selIndex].text; 
    return selText;
}

function openCPSSelectedbildDataSource(controlId,dictCollectionId, parentItemId) {
	Liferay.Service(
			  '/opencps-portlet.dictitem/get-dictitems-inuse-by-dictcollectionId_parentItemId_datasource',
			  {
			    dictCollectionId: dictCollectionId,
			    parentItemId: parentItemId
			  },
			  function(obj) {
				var comboTarget = document.getElementById(controlId); 
			    for(j in obj){
                    var sub_key = j;
                    var sub_val = obj[j];
                    var newOpt = comboTarget.appendChild(document.createElement('option'));
					newOpt.value = sub_key;
					newOpt.text = sub_val;
                }
			  }
			);
}
function openCPSSelectDataSource(dictCollectionId) {
	return "/api/jsonws/opencps-portlet.dictitem/get-dictitems-inuse-by-dictcollectionId_parentItemId_datasource/dict-collection-id/"+dictCollectionId+"/parent-item-id/0?p_auth="+"<%=auTock %>";
}

</script>
<style type="text/css" media="screen">
.editor {
    margin: 0;
    display: block;
    height: 500px;
    overflow: scroll;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
}
.editor2 {
    margin: 0;
    display: block;
    height: 200px;
    overflow: scroll;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
}
.ace_folding-enabled>.ace_gutter-cell {
    color: #fff;
}

.ace-github .ace_gutter {
    background: #2587b4 !important;
    color: #FFF !important;
    font-weight: bold !important;
}

</style>
