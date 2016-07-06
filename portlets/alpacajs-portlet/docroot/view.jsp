
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
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<aui:form name="fm">

    <div>
        <div style="float: left; width: 20%;">
            <div style="padding-left: 20px; padding-right: 40px;">
                <liferay-ui:header title='alpcajs-tool' />
                <aui:button-row>
                    <aui:input type="radio" name="typeField" label="label"
                        inlineField="<%=true%>" onClick="showControl('label');"></aui:input>
                    <aui:input type="radio" name="typeField" label="text"
                        inlineField="<%=true%>" onClick="showControl('text');"></aui:input>
                    <aui:input type="radio" name="typeField" label="textarea"
                        inlineField="<%=true%>" onClick="showControl('textarea');"></aui:input>
                    <aui:input type="radio" name="typeField" label="date"
                        inlineField="<%=true%>" onClick="showControl('date');"></aui:input>
                    <aui:input type="radio" name="typeField" label="datetime"
                        inlineField="<%=true%>" onClick="showControl('datetime');"></aui:input>
                    <aui:input type="radio" name="typeField" label="select"
                        inlineField="<%=true%>" onClick="showControl('select');"></aui:input>
                    <aui:input type="radio" name="typeField" label="arrays"
                        inlineField="<%=true%>" onClick="showControl('array');"></aui:input>
                </aui:button-row>

                <aui:row>
                    <div id="<portlet:namespace />nameDiv" class="hidden">
                        <aui:input type="text" name="name" cssClass="form-input-100"></aui:input>
                    </div>
                    <div id="<portlet:namespace />labelDiv" class="hidden">
                        <aui:input type="text" name="label" cssClass="form-input-100"></aui:input>
                    </div>
                    <div id="<portlet:namespace />requiredDiv" class="hidden">
                        <aui:input type="text" name="required" cssClass="form-input-100" value="false"></aui:input>
                    </div>
                    <div id="<portlet:namespace />cssClassDiv" class="hidden">
                        <aui:input type="text" name="cssClass" cssClass="form-input-100" value="form-input-80"></aui:input>
                    </div>
                    <div id="<portlet:namespace />dataSourceDiv" class="hidden">
                    DataSource
                       <div  style="float: left; width: 65%;">
                           <aui:input type="text" name="dataSource" label="" cssClass="dataSourceText"></aui:input>
                       </div>
                       <div style="float: left;">
                           <input class="button" type="button"
                        name="create" value="select"
                        onClick="selectCollection()"></input>
                       </div>
                    </div>
                    <div id="<portlet:namespace />arraysDiv" class="hidden">
                        <aui:input type="text" name="col1" cssClass="form-input-100"></aui:input>
                        <aui:input type="text" name="col2" cssClass="form-input-100"></aui:input>
                        <aui:input type="text" name="col3" cssClass="form-input-100"></aui:input>
                        <aui:input type="text" name="col4" cssClass="form-input-100"></aui:input>
                        <aui:input type="text" name="col5" cssClass="form-input-100"></aui:input>
                    </div>
                    <table style="width: 100%;" class="hidden">
                        <tr>
                            <td><aui:input type="checkbox" name="mouseover"
                                    value="mouseover" label="mouseover" inlineField="<%=true%>"></aui:input>
                            </td>
                            <td><aui:input type="checkbox" name="mouseout"
                                    value="mouseout" label="mouseout" inlineField="<%=true%>"></aui:input>
                            </td>
                        </tr>
                        <tr>
                            <td><aui:input type="checkbox" name="change" value="change"
                                    label="change" inlineField="<%=true%>"></aui:input></td>
                            <td><aui:input type="checkbox" name="focus" value="focus"
                                    label="focus" inlineField="<%=true%>"></aui:input></td>
                        </tr>
                        <tr>
                            <td><aui:input type="checkbox" name="blur" value="blur"
                                    label="blur" inlineField="<%=true%>"></aui:input></td>
                            <td><aui:input type="checkbox" name="keypress"
                                    value="keypress" label="keypress" inlineField="<%=true%>"></aui:input>
                            </td>
                        </tr>
                        <tr>
                            <td><aui:input type="checkbox" name="keydown"
                                    value="keydown" label="keydown" inlineField="<%=true%>"
                                    onClick=""></aui:input></td>
                            <td><aui:input type="checkbox" name="keyup" value="keyup"
                                    label="keyup" inlineField="<%=true%>"></aui:input></td>
                        </tr>
                        <tr>
                            <td><aui:input type="checkbox" name="click" value="click"
                                    label="click" inlineField="<%=true%>"></aui:input></td>
                            <td><aui:input type="checkbox" name="ready" value="ready"
                                    label="ready" inlineField="<%=true%>"></aui:input></td>
                        </tr>
                    </table>
                </aui:row>
                <aui:button-row>
                    <portlet:actionURL var="buildJsonFormURL" name="buildJsonForm"></portlet:actionURL>
                    <input class="button" style="width: 100%;" type="button"
                        name="create" value="add"
                        onClick="alpaca_build_control('<%=buildJsonFormURL.toString()%>')"></input>
                    <p></p>
                    <input class="button" style="width: 100%;" type="button"
                        name="create" value="refresh"
                        onClick="refreshURL()"></input>
                    <aui:input type="textarea" cssClass="updateForm" label="updateForm" name="formUpdate"></aui:input>
                    <portlet:actionURL var="buildJsonFormUpdateURL" name="buildJsonFormUpdate"></portlet:actionURL>
                    <input class="button" style="width: 100%;" type="button"
                        name="create" value="run"
                        onClick="alpaca_updateForm('<%=buildJsonFormUpdateURL.toString()%>')"></input>
                </aui:button-row>
                <aui:input type="hidden" name="viewValue" />
                <aui:input type="hidden" name="countId" />
                <aui:input type="hidden" name="schemaValue" />
                <aui:input type="hidden" name="optionValue" />
                <aui:input type="hidden" name="typeControl" />
                <aui:input type="hidden" name="editorDKParam" />
                <aui:input type="hidden" name="editorDK" />
                
            </div>
        </div>

        <div style="float: left; width: 80%;">
            <liferay-ui:header title='alpcajs-source' />

            <table class='table'>
                <tbody>
                    <tr>
                        <td width="50%">
                          schema
                            <div id="editor_paramater" class="editor"></div>
                        </td>
                        <td>
                          options
                            <div id="editor" class="editor"></div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><aui:button-row>
                                <portlet:actionURL var="buildJsonLayoutFormURL"
                                    name="buildJsonLayoutForm"></portlet:actionURL>
                                <input class="button" type="button" name="create"
                                    value="120-column"
                                    onClick="alpaca_build_layOut('<%=buildJsonLayoutFormURL.toString()%>','120')"></input>
                                <input class="button" type="button" name="create"
                                    value="60-60-column"
                                    onClick="alpaca_build_layOut('<%=buildJsonLayoutFormURL.toString()%>','60-60')"></input>
                                <input class="button" type="button" name="create"
                                    value="30-60-30-column"
                                    onClick="alpaca_build_layOut('<%=buildJsonLayoutFormURL.toString()%>','30-60-30')"></input>
                                <input class="button" type="button" name="create"
                                    value="40-40-40-column"
                                    onClick="alpaca_build_layOut('<%=buildJsonLayoutFormURL.toString()%>','40-40-40')"></input>
                                <input class="button" type="button" name="create"
                                    value="80-40-column"
                                    onClick="alpaca_build_layOut('<%=buildJsonLayoutFormURL.toString()%>','80-40')"></input>
                                <input class="button" type="button" name="create"
                                    value="60-60-table"
                                    onClick="alpaca_build_layOut('<%=buildJsonLayoutFormURL.toString()%>','60-60-table')"></input>
                                    <portlet:actionURL var="previewActionURL" name="previewAction"></portlet:actionURL>
                                <input class=" btn" type="button" style="padding: 4px 10px;"
                                    name="create" value="refresh layout"
                                    onClick="refreshURLLayout()"></input>
                                <input class=" btn btn-primary" type="button" style="padding: 4px 10px;"
                                    name="create" value="preview"
                                    onClick="previewAlpacaForm('<%=previewActionURL.toString()%>')"></input>
                            </aui:button-row>
                            view
                            <div id="editorLayout" class="editor2"></div></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="layOutView">
                                
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</aui:form>
<script src="<%=request.getContextPath()%>/js/ace.js"
    type="text/javascript" charset="utf-8"></script>
<aui:script use="aui-base,liferay-portlet-url,aui-io">
Liferay.provide(window, 'selectCollection', function() {
    
    var A = AUI();
    var portletURL = Liferay.PortletURL.createURL('<%= PortletURLFactoryUtil.create(request,"alpacajs_WAR_alpacajsportlet", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>');
    portletURL.setParameter("mvcPath", "/html/collection.jsp");
    portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString()%>"); 
    portletURL.setPortletMode("normal");
    openDialog(portletURL.toString(), '<portlet:namespace />collection', '<%= UnicodeLanguageUtil.get(pageContext, "select") %>');
    
});
    Liferay.provide(window, 'previewAlpacaForm', function(url) {
        
        var A = AUI();
        var editor_paramater = ace.edit("editor_paramater");
        var editor = ace.edit("editor");
        var editorLayout = ace.edit("editorLayout");
        AUI()
        .io(
                url,
                {
                    method : 'POST',
                    data : {
                        <portlet:namespace/>alpacaSchema : editor_paramater.getValue().substring(1, editor_paramater.getValue().length-1) +","
                        +editor.getValue().substring(1, editor.getValue().length-1) + ","
                        +editorLayout.getValue().substring(1, editorLayout.getValue().length-1)
                    },
                    on : {
                        start : function() {
                            // Set HMTL
                            console.log("alpaca_build_layOut start!");
                        },

                        success : function(id, xhr) {
                            // Grab the elements
                        	var portletURL = Liferay.PortletURL.createURL('<%= PortletURLFactoryUtil.create(request,"alpacajs_WAR_alpacajsportlet", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>');
                            portletURL.setParameter("mvcPath", "/html/dossier_dynamic_form.jsp");
                            portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString()%>"); 
                            portletURL.setPortletMode("normal");
                            openDialog(portletURL.toString(), '<portlet:namespace />assignToUser', '<%= UnicodeLanguageUtil.get(pageContext, "preview") %>');
                        },

                        end : function() {
                            console.log("alpaca_build_layOut end!");
                        }
                    }
                });
        
    });
    
    </aui:script>
<script>
function alpaca_updateForm(url) {
    var A = AUI();
    var updateForm = A.one("#<portlet:namespace />formUpdate");
    var editorDKParam = A.one("#<portlet:namespace />editorDKParam");
    var editorDK = A.one("#<portlet:namespace />editorDK");
    var schemaValue = A.one("#<portlet:namespace />schemaValue");
    var optionValue = A.one("#<portlet:namespace />optionValue");
    var viewValue = A.one("#<portlet:namespace />viewValue");
    AUI()
            .io(
                    url,
                    {
                        method : 'POST',
                        data : {
                            <portlet:namespace/>updateForm : updateForm.val()
                        },
                        on : {
                            start : function() {
                                // Set HMTL
                                console.log("updateForm start!");
                            },

                            success : function(id, xhr) {
                                // Grab the elements
                                var json = JSON.parse(xhr.responseText);
                                editorDKParam.val(json.editorDKParam);
                                editorDK.val(json.editor);
                                schemaValue.val(json.schemaValue);
                                optionValue.val(json.optionValue);
                                var editor_paramater = ace
                                        .edit("editor_paramater");
                                var myObject = eval('({'
                                        + json.editorDKParam + '})');
                                editor_paramater.setValue(JSON.stringify(
                                        myObject, null, 4), -1);
                                var editor = ace.edit("editor");
                                var myObject2 = eval('({' + json.editor
                                        + '})');
                                editor
                                        .setValue(
                                                JSON
                                                        .stringify(
                                                                myObject2,
                                                                null, 4)
                                                        .replace(
                                                                /"function/g,
                                                                "function")
                                                        .replace(/}\"/g,
                                                                "}")
                                                        .replace(
                                                                /openCPSSelectDataSource\(/g,
                                                                "openCPSSelectDataSource\(\"")
                                                        .replace(
                                                                    /openCPSSelectedTextValue\(/g,
                                                                    "openCPSSelectedTextValue\(\"")
                                                            .replace(
                                                                    /replaceKey\({\(/g,
                                                                    "\(\"")
                                                          .replace(
                                                                    /\"replaceTruncae{callback\(/g,
                                                                    "")     
                                                            .replace(
                                                                    /\);replaceTruncae\);}/g,
                                                                    "\"\)")  
                                                             .replace(/\)}\);/g,
                                                                    "\"\);")
                                                        .replace(/\);\);/g,
                                                                "\"\);\);"),
                                                -1);
                                viewValue.val(json.viewValue);
                                var editorLayout = ace.edit("editorLayout");
                                var myObject3 = eval('({'
                                        + json.editorLayout + '})');
                                editorLayout.setValue(JSON.stringify(
                                        myObject3, null, 4), -1);
                            },

                            end : function() {
                                console.log("updateForm end!");
                            }
                        }
                    });
}
function refreshURL(){
    var A = AUI();
    var viewValue = A.one("#<portlet:namespace />viewValue");
    var countId = A.one("#<portlet:namespace />countId");
    var schemaValue = A.one("#<portlet:namespace />schemaValue");
    var optionValue = A.one("#<portlet:namespace />optionValue");
    var typeControl = A.one("#<portlet:namespace />typeControl");
    var editorDKParam = A.one("#<portlet:namespace />editorDKParam");
    var editorDK = A.one("#<portlet:namespace />editorDK");
    viewValue.val("");
    countId.val("");
    schemaValue.val("");
    optionValue.val("");
    typeControl.val("");
    editorDKParam.val("");
    editorDK.val("");
    location.reload();
}
function refreshURLLayout(){
    var A = AUI();
    var viewValue = A.one("#<portlet:namespace />viewValue");
    var countId = A.one("#<portlet:namespace />countId");
    viewValue.val("");
    countId.val("");
    var editorLayout = ace.edit("editorLayout");
    editorLayout.setValue("", -1);
}
    function alpaca_build_control(url) {
        var A = AUI();
        var editorDKParam = A.one("#<portlet:namespace />editorDKParam");
        var editorDK = A.one("#<portlet:namespace />editorDK");
        var schemaValue = A.one("#<portlet:namespace />schemaValue");
        var optionValue = A.one("#<portlet:namespace />optionValue");
        AUI()
                .io(
                        url,
                        {
                            method : 'POST',
                            data : {
                                <portlet:namespace/>name : A.one(
                                        "#<portlet:namespace />name").val(),
                                <portlet:namespace/>label : A.one(
                                        "#<portlet:namespace />label").val(),
                                <portlet:namespace/>required : A.one(
                                        "#<portlet:namespace />required").val(),
                                <portlet:namespace/>cssClass : A.one(
                                        "#<portlet:namespace />cssClass").val(),
                                <portlet:namespace/>dataSource : A.one(
                                        "#<portlet:namespace />dataSource")
                                        .val(),
                                <portlet:namespace/>typeControl : A.one(
                                        "#<portlet:namespace />typeControl")
                                        .val(),
                                <portlet:namespace/>col1 : A.one(
                                        "#<portlet:namespace />col1")
                                        .val(),
                                <portlet:namespace/>col2 : A.one(
                                        "#<portlet:namespace />col2")
                                        .val(),
                                <portlet:namespace/>col3 : A.one(
                                        "#<portlet:namespace />col3")
                                        .val(),
                                <portlet:namespace/>col4 : A.one(
                                        "#<portlet:namespace />col4")
                                        .val(),
                                <portlet:namespace/>col5 : A.one(
                                        "#<portlet:namespace />col5")
                                        .val(),
                                <portlet:namespace/>mouseover : A.one(
                                        "#<portlet:namespace />mouseover")
                                        .val(),
                                <portlet:namespace/>mouseout : A.one(
                                        "#<portlet:namespace />mouseout").val(),
                                <portlet:namespace/>change : A.one(
                                        "#<portlet:namespace />change").val(),
                                <portlet:namespace/>focus : A.one(
                                        "#<portlet:namespace />focus").val(),
                                <portlet:namespace/>blur : A.one(
                                        "#<portlet:namespace />blur").val(),
                                <portlet:namespace/>keypress : A.one(
                                        "#<portlet:namespace />keypress").val(),
                                <portlet:namespace/>keydown : A.one(
                                        "#<portlet:namespace />keypress").val(),
                                <portlet:namespace/>keyup : A.one(
                                        "#<portlet:namespace />keyup").val(),
                                <portlet:namespace/>click : A.one(
                                        "#<portlet:namespace />click").val(),
                                <portlet:namespace/>ready : A.one(
                                        "#<portlet:namespace />ready").val(),
                                <portlet:namespace/>schemaValue : A.one(
                                        "#<portlet:namespace />schemaValue")
                                        .val(),
                                <portlet:namespace/>optionValue : A.one(
                                        "#<portlet:namespace />optionValue")
                                        .val()
                            },
                            on : {
                                start : function() {
                                    // Set HMTL
                                    console.log("alpaca_build_control start!");
                                },

                                success : function(id, xhr) {
                                    // Grab the elements
                                    var json = JSON.parse(xhr.responseText);
                                    editorDKParam.val(json.editorDKParam);
                                    editorDK.val(json.editor);
                                    schemaValue.val(json.schemaValue);
                                    optionValue.val(json.optionValue);
                                    var editor_paramater = ace
                                            .edit("editor_paramater");
                                    var myObject = eval('({'
                                            + json.editorDKParam + '})');
                                    editor_paramater.setValue(JSON.stringify(
                                            myObject, null, 4), -1);
                                    var editor = ace.edit("editor");
                                    var myObject2 = eval('({' + json.editor
                                            + '})');
                                    editor
                                            .setValue(
                                                    JSON
                                                            .stringify(
                                                                    myObject2,
                                                                    null, 4)
                                                            .replace(
                                                                    /"function/g,
                                                                    "function")
                                                            .replace(/}\"/g,
                                                                    "}")
                                                            .replace(
                                                                    /openCPSSelectDataSource\(/g,
                                                                    "openCPSSelectDataSource\(\"")
                                                            .replace(
                                                                    /openCPSSelectedTextValue\(/g,
                                                                    "openCPSSelectedTextValue\(\"")
                                                            .replace(
                                                                    /replaceKey\({\(/g,
                                                                    "\(\"")
                                                             .replace(
                                                                    /\"replaceTruncae{callback\(/g,
                                                                    "")     
                                                            .replace(
                                                                    /\);replaceTruncae\);}/g,
                                                                    "\"\)")  
                                                             .replace(/\)}\);/g,
                                                                    "\"\);")
                                                             .replace(/\)\);}/g,
                                                                    "\"\)\);}")
                                                            .replace(/\);\);/g,
                                                                    "\"\);\);"),
                                                    -1);
                                },

                                end : function() {
                                    console.log("alpaca_build_control end!");
                                }
                            }
                        });
    }
    function alpaca_build_layOut(url, layoutId) {
        var A = AUI();
        var viewValue = A.one("#<portlet:namespace />viewValue");
        var countId = A.one("#<portlet:namespace />countId");
        var editor = ace.edit("editor");
        AUI()
                .io(
                        url,
                        {
                            method : 'POST',
                            data : {
                                <portlet:namespace/>layoutId : layoutId,
                                <portlet:namespace/>viewValue : A.one(
                                        "#<portlet:namespace />viewValue")
                                        .val(),
                                <portlet:namespace/>countId : A.one(
                                        "#<portlet:namespace />countId").val(),
                                <portlet:namespace/>optionValue : editor.getValue().substring(1, editor.getValue().length-1)
                            },
                            on : {
                                start : function() {
                                    // Set HMTL
                                    console.log("alpaca_build_layOut start!");
                                },

                                success : function(id, xhr) {
                                    // Grab the elements
                                    var json = JSON.parse(xhr.responseText);
                                    viewValue.val(json.viewValue);
                                    countId.val(json.countId);
                                    var editorLayout = ace.edit("editorLayout");
                                    var myObject = eval('({'
                                            + json.editorLayout + '})');
                                    editorLayout.setValue(JSON.stringify(
                                            myObject, null, 4), -1);
                                    var layOutView = A.one("#layOutView");
                                    layOutView.set("innerHTML","");
                                    var errorMessageNode = A.Node.create(json.viewValue);
                                             errorMessageNode.appendTo(layOutView);
                                             
                                             
                                },

                                end : function() {
                                    console.log("alpaca_build_layOut end!");
                                }
                            }
                        });
    }
    function showControl(key) {
        var A = AUI();

        var typeControl = A.one('#<portlet:namespace />typeControl');
        typeControl.val(key);
        var nameDiv = A.one('#<portlet:namespace />nameDiv');
        var labelDiv = A.one('#<portlet:namespace />labelDiv');
        var requiredDiv = A.one('#<portlet:namespace />requiredDiv');
        var cssClassDiv = A.one('#<portlet:namespace />cssClassDiv');
        var dataSource = A.one('#<portlet:namespace />dataSourceDiv');
        var arraysDiv = A.one('#<portlet:namespace />arraysDiv');
        if (key === 'label') {
            nameDiv.removeClass('hidden');
            labelDiv.removeClass('hidden');
            requiredDiv.removeClass('hidden');
            cssClassDiv.removeClass('hidden');
            dataSource.removeClass('hidden');
            nameDiv.addClass('');
            labelDiv.addClass('');
            requiredDiv.addClass('hidden');
            cssClassDiv.addClass('');
            dataSource.addClass('hidden');
            arraysDiv.addClass('hidden');
        } else if (key === 'text' || key === 'textarea' || key === 'date'
                || key === 'datetime') {
            nameDiv.removeClass('hidden');
            labelDiv.removeClass('hidden');
            requiredDiv.removeClass('hidden');
            cssClassDiv.removeClass('hidden');
            dataSource.removeClass('hidden');
            nameDiv.addClass('');
            labelDiv.addClass('');
            requiredDiv.addClass('');
            cssClassDiv.addClass('');
            dataSource.addClass('hidden');
            arraysDiv.addClass('hidden');
        } else if (key === 'select') {
            nameDiv.removeClass('hidden');
            labelDiv.removeClass('hidden');
            requiredDiv.removeClass('hidden');
            cssClassDiv.removeClass('hidden');
            dataSource.removeClass('hidden');
            nameDiv.addClass('');
            labelDiv.addClass('');
            requiredDiv.addClass('');
            cssClassDiv.addClass('');
            dataSource.addClass('');
            arraysDiv.addClass('hidden');
        }else if (key === 'array') {
            nameDiv.removeClass('hidden');
            labelDiv.removeClass('hidden');
            requiredDiv.removeClass('hidden');
            cssClassDiv.removeClass('hidden');
            dataSource.removeClass('hidden');
            arraysDiv.removeClass('hidden');
            nameDiv.addClass('');
            labelDiv.addClass('hidden');
            requiredDiv.addClass('hidden');
            cssClassDiv.addClass('hidden');
            dataSource.addClass('hidden');
            arraysDiv.addClass('');
        }
    }
    AUI().ready(function(A) {
    });
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/github");
    editor.session.setMode("ace/mode/javascript");

    var editor_paramater = ace.edit("editor_paramater");
    editor_paramater.setTheme("ace/theme/github");
    editor_paramater.session.setMode("ace/mode/javascript");

    var editor_paramater = ace.edit("editorLayout");
    editor_paramater.setTheme("ace/theme/github");
    editor_paramater.session.setMode("ace/mode/javascript");
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

.aui .form-input-100 {
    width: 100% !important;
}
.dataSourceText{
    width: 80% !important;
}
.updateForm{
    width: 93% !important;
}
#wrapper{
padding: 0px !important;
}
#layOutView div[id^="column-"],#layOutView  div[id*=" column-"] {border: 1px solid #333;}
#layOutView .row-fluid{
padding-bottom: 5px !important;
}


<%
for(int istyle = 1; istyle < 150; istyle++){
%>
#layOutView #column-<%=istyle%>:after {

    content: "column-<%=istyle%>";
    position: relative;
    left: 47%;

}
<%}%>

</style>
<aui:script>
var A = AUI();
     Liferay.provide(window, 'updateDataFromPopUp', function(jsonDataFromPopUp) {
    	 var dataSource = A.one("#<portlet:namespace />dataSource");
    	 dataSource.val(jsonDataFromPopUp);
        }
     );
 </aui:script>