package com.fds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BuildFormAction extends MVCPortlet {

	public void buildJsonForm(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		 String name = ParamUtil.getString(actionRequest, "name");
         String label = ParamUtil.getString(actionRequest, "label");
         String required = ParamUtil.getString(actionRequest, "required");
         String cssClass = ParamUtil.getString(actionRequest, "cssClass");
         String dataSource = ParamUtil.getString(actionRequest, "dataSource");
         String typeControl = ParamUtil.getString(actionRequest, "typeControl");
         String col1 = ParamUtil.getString(actionRequest, "col1");
         String col2 = ParamUtil.getString(actionRequest, "col2");
         String col3 = ParamUtil.getString(actionRequest, "col3");
         String col4 = ParamUtil.getString(actionRequest, "col4");
         String col5 = ParamUtil.getString(actionRequest, "col5");
         String mouseover = ParamUtil.getString(actionRequest, "mouseover");
         String mouseout = ParamUtil.getString(actionRequest, "mouseout");
         String change = ParamUtil.getString(actionRequest, "change");
         String focus = ParamUtil.getString(actionRequest, "focus");
         String blur = ParamUtil.getString(actionRequest, "blur");
         String keypress = ParamUtil.getString(actionRequest, "keypress");
         String keydown = ParamUtil.getString(actionRequest, "keydown");
         String keyup = ParamUtil.getString(actionRequest, "keyup");
         String click = ParamUtil.getString(actionRequest, "click");
         String ready = ParamUtil.getString(actionRequest, "ready");
         String schemaValue = ParamUtil.getString(actionRequest, "schemaValue");
         String optionValue = ParamUtil.getString(actionRequest, "optionValue");
         schemaValue = schemaValue.length()>1?(schemaValue + ","):schemaValue;
         optionValue = optionValue.length()>1?(optionValue + ","):optionValue;
         System.out.println("**col1**"+col1);
         System.out.println("**col2**"+col2);
         System.out.println("**col3**"+col3);
         System.out.println("**col4**"+col4);
         System.out.println("**col5**"+col5);
         String controlSchema = ""; 
         String controlOption = ""; 
         HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
         String isArray = (String)httpRequest.getSession().getAttribute("isArray");
         String fieldLayout = (String)httpRequest.getSession().getAttribute("fieldsLayout");
         String nameArray = (String)httpRequest.getSession().getAttribute("nameArray");
         System.out.println("BuildFormAction.buildJsonForm()"+isArray);
         if(Validator.isNotNull(isArray) && Validator.isNotNull(fieldLayout)){
        	 httpRequest.getSession().setAttribute("isArray", isArray);
             httpRequest.getSession().setAttribute("fieldsLayout", fieldLayout);
             httpRequest.getSession().setAttribute("nameArray", nameArray);
         }
         
        if(typeControl.equalsIgnoreCase("label")){
        	controlSchema = schemaValue + "\""+name + "\":"+"{\"type\": \"object\",\"required\": \"false\", \"properties\": {}}";
        	controlOption = optionValue + "\""+name + "\":"+"{\"id\": \"" + name+ "\",\"label\": \"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+label+"\",\"fieldClass\": \""+cssClass+"\",\"legendStyle\": \"\", \"fields\": {} }";
        }else if(typeControl.equalsIgnoreCase("text")){
        	controlSchema = schemaValue + "\""+name + "\":"+"{\"type\": \"object\",\"required\": "+required+" }";
        	controlOption = optionValue + "\""+name + "\":"+"{\"id\": \"" + name+ "\",\"name\": \"" + name+ "\",\"type\": \""+typeControl+"\",\"label\": \""+label+"\",\"fieldClass\": \""+cssClass+"\" }";
        }else if(typeControl.equalsIgnoreCase("textarea")){
        	controlSchema = schemaValue + "\""+name + "\":"+"{\"type\": \"object\",\"required\": "+required+" }";
        	controlOption = optionValue + "\""+name + "\":"+"{\"id\": \"" + name+ "\",\"name\": \"" + name+ "\",\"type\": \""+typeControl+"\",\"label\": \""+label+"\",\"fieldClass\": \""+cssClass+"\", \"rows\": 5 }";
        }else if(typeControl.equalsIgnoreCase("date")){
        	controlSchema = schemaValue + "\""+name + "\":"+"{\"type\": \"object\",\"required\": "+required+" }";
        	controlOption = optionValue + "\""+name + "\":"+"{\"id\": \"" + name+ "\",\"name\": \"" + name+ "\",\"type\": \""+typeControl+"\",\"label\": \""+label+"\",\"fieldClass\": \""+cssClass+"\",\"picker\": {\"useCurrent\": false,\"format\": \"DD/MM/YYYY\",\"locale\": \"en_US\",\"dayViewHeaderFormat\": \"MMMM YYYY\",\"extraFormats\": []},\"dateFormat\": \"DD/MM/YYYY\", \"manualEntry\": false,\"fields\": {} }";
        }else if(typeControl.equalsIgnoreCase("datetime")){
        	controlSchema = schemaValue + "\""+name + "\":"+"{\"type\": \"object\",\"required\": "+required+" }";
        	controlOption = optionValue + "\""+name + "\":"+"{\"id\": \"" + name+ "\",\"name\": \"" + name+ "\",\"type\": \""+typeControl+"\",\"label\": \""+label+"\",\"fieldClass\": \""+cssClass+"\",\"picker\": {\"useCurrent\": false,\"format\": \"DD/MM/YYYY HH:mm:ss\",\"locale\": \"en_US\",\"dayViewHeaderFormat\": \"MMMM YYYY\",\"extraFormats\": [\"MM/DD/YYYY hh:mm:ss a\",\"MM/DD/YYYY HH:mm\",\"MM/DD/YYYY\"]},\"dateFormat\": \"DD/MM/YYYY HH:mm:ss\", \"manualEntry\": false,\"fields\": {} }";
        }else if(typeControl.equalsIgnoreCase("select")){
        	controlSchema = schemaValue + "\""+name + "\":"+"{\"type\": \"object\",\"required\": "+required+" },"+ "\""+name + "Text\":"+"{\"type\": \"object\",\"required\": "+required+" }";
        	controlOption = optionValue + "\""+name + "\":"+"{\"id\": \"" + name+ "\",\"name\": \"" + name+ "\",\"type\": \""+typeControl+"\",\"label\": \""+label+"\",\"fieldClass\": \""+cssClass+"\", \"size\": -1, \"multiple\": false, \"emptySelectFirst\":true, \"dataSource\": \"replaceTruncae{callback(openCPSSelectDataSource("+dataSource+");replaceTruncae);}\", \"events\": { \"change\": \"function() {var "+name+"Text = $replaceKey({(#"+name+"Text)});"+name+"Text.val(openCPSSelectedTextValue("+name+"));}\"} },"+ "\""+name + "Text\":"+"{\"id\": \"" + name+ "Text\",\"name\": \"" + name+ "Text\",\"type\": \"hidden\",\"label\": \"\" }";
        }else if(typeControl.equalsIgnoreCase("array")){
        	String schemaColumn = "";
        	httpRequest.getSession().setAttribute("isArray", "true");
        	httpRequest.getSession().setAttribute("nameArray", name);
			if(Validator.isNotNull(col5)){
				schemaColumn = "\"col1\": { \"type\": \"string\", \"title\": \"" + col1 +"\"},"
						+ "\"col2\": { \"type\": \"string\", \"title\": \"" + col2 +"\"},"
								+ "\"col3\": { \"type\": \"string\", \"title\": \"" + col3 +"\"},"
										+ "\"col4\": { \"type\": \"string\", \"title\": \"" + col4 +"\"},"
												+ "\"col5\": { \"type\": \"string\", \"title\": \"" + col5 +"\"}";
				httpRequest.getSession().setAttribute("fieldsLayout", "\"/"+name+"/col1\": { \"templates\": { \"control\" : \"<div style='float:left; width: 20%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
						+ "\"/"+name+"/col2\": { \"templates\": { \"control\" : \"<div style='float:left; width: 20%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
								+ "\"/"+name+"/col3\": { \"templates\": { \"control\" : \"<div style='float:left; width: 20%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
										+ "\"/"+name+"/col4\": { \"templates\": { \"control\" : \"<div style='float:left; width: 20%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
												+ "\"/"+name+"/col5\": { \"templates\": { \"control\" : \"<div style='float:left; width: 20%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}}");
			}else if(Validator.isNotNull(col4)){
				schemaColumn = "\"col1\": { \"type\": \"string\", \"title\": \"" + col1 +"\"},"
						+ "\"col2\": { \"type\": \"string\", \"title\": \"" + col2 +"\"},"
								+ "\"col3\": { \"type\": \"string\", \"title\": \"" + col3 +"\"},"
										+ "\"col4\": { \"type\": \"string\", \"title\": \"" + col4 +"\"}";
				httpRequest.getSession().setAttribute("fieldsLayout", "\"/"+name+"/col1\": { \"templates\": { \"control\" : \"<div style='float:left; width: 25%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
						+ "\"/"+name+"/col2\": { \"templates\": { \"control\" : \"<div style='float:left; width: 25%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
								+ "\"/"+name+"/col3\": { \"templates\": { \"control\" : \"<div style='float:left; width: 25%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
										+ "\"/"+name+"/col4\": { \"templates\": { \"control\" : \"<div style='float:left; width: 25%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}}");
			}else if(Validator.isNotNull(col3)){
				schemaColumn = "\"col1\": { \"type\": \"string\", \"title\": \"" + col1 +"\"},"
						+ "\"col2\": { \"type\": \"string\", \"title\": \"" + col2 +"\"},"
								+ "\"col3\": { \"type\": \"string\", \"title\": \"" + col3 +"\"}";
				httpRequest.getSession().setAttribute("fieldsLayout", "\"/"+name+"/col1\": { \"templates\": { \"control\" : \"<div style='float:left; width: 30%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
						+ "\"/"+name+"/col2\": { \"templates\": { \"control\" : \"<div style='float:left; width: 30%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
								+ "\"/"+name+"/col3\": { \"templates\": { \"control\" : \"<div style='float:left; width: 40%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}}");
			}else if(Validator.isNotNull(col2)){
				schemaColumn = "\"col1\": { \"type\": \"string\", \"title\": \"" + col1 +"\"},"
						+ "\"col2\": { \"type\": \"string\", \"title\": \"" + col2 +"\"}";    	
				httpRequest.getSession().setAttribute("fieldsLayout", "\"/"+name+"/col1\": { \"templates\": { \"control\" : \"<div style='float:left; width: 50%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}},"
						+ "\"/"+name+"/col2\": { \"templates\": { \"control\" : \"<div style='float:left; width: 50%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}}");
			}else if(Validator.isNotNull(col1)){
        		schemaColumn = "\"col1\": { \"type\": \"string\", \"title\": \"" + col1 +"\"}";
        		httpRequest.getSession().setAttribute("fieldsLayout", "\"/"+name+"/col1\": { \"templates\": { \"control\" : \"<div style='float:left; width: 100%;'>{{#if options.label}}<label class='{{#if options.labelClass}}{{options.labelClass}}{{/if}} alpaca-control-label' for='{{id}}'>{{{options.label}}}</label>{{/if}}{{#control}}{{/control}}</div>\"" + "}}");
        	}
			
	 		
        	controlSchema = schemaValue + "\""+name + "\":"+"{\"type\": \"object\",\"required\": false, \"properties\": {}, \"items\": { \"type\": \"object\", \"properties\": {"+schemaColumn+" }}}";
        	controlOption = optionValue + "\""+name + "\":"+"{\"id\": \"" + name+ "\",\"name\": \"" + name+ "\",\"type\": \""+typeControl+"\",\"label\": \"\",\"fieldClass\": \"fullHeight\",\"legendStyle\": \"button\",\"toolbarStyle\": \"button\",\"actionbarStyle\": \"top\",\"toolbarSticky\": true,\"hideToolbarWithChildren\": false,\"fields\": {}, \"items\":{ \"type\": \"object\", \"properties\": {"+schemaColumn+" }}}";
        }
        String schemaStart = "\"schema\": {\"type\": \"object\",\"required\": false,\"properties\": {";
        String schemaEnd = "}}";
        
        String optionStart = "\"options\": {\"type\": \"object\",\"legendStyle\": \"\",\"fields\": {";
        String optionEnd = "}}";
		JSONObject jsonObject = JSONFactoryUtil
				.createJSONObject();
		jsonObject
				.put("editorDKParam", schemaStart+ controlSchema +schemaEnd);
		jsonObject
				.put("editor", optionStart + controlOption + optionEnd);
		jsonObject
				.put("schemaValue", controlSchema );
		jsonObject
				.put("optionValue", controlOption);
		writeJSON(actionRequest, actionResponse, jsonObject);
	}	
	public void buildJsonLayoutForm(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		 String layoutId = ParamUtil.getString(actionRequest, "layoutId");
		 String viewValue = ParamUtil.getString(actionRequest, "viewValue");
		 long countId = ParamUtil.getLong(actionRequest, "countId");
         System.out.println("**viewValue**"+viewValue);
         HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
         String isArray = (String)httpRequest.getSession().getAttribute("isArray");
         String fieldLayout = (String)httpRequest.getSession().getAttribute("fieldsLayout");
         String nameArray = (String)httpRequest.getSession().getAttribute("nameArray");
         System.out.println("BuildFormAction.buildJsonLayoutForm()"+isArray);
         if(Validator.isNotNull(isArray) && Validator.isNotNull(fieldLayout)){
        	 httpRequest.getSession().setAttribute("isArray", isArray);
             httpRequest.getSession().setAttribute("fieldsLayout", fieldLayout);
             httpRequest.getSession().setAttribute("nameArray", nameArray);
         }
        String viewValueSchema = ""; 
        if(layoutId.equalsIgnoreCase("120")){
        	viewValueSchema = viewValue+"<div class='row-fluid'><div class='span12' id='column-"+ ++countId +"'></div></div>";
        }else if(layoutId.equalsIgnoreCase("60-60")){
        	viewValueSchema = viewValue+"<div class='row-fluid'><div class='span6' id='column-"+ ++countId +"'></div><div class='span6' id='column-"+ ++countId +"'></div></div>";
        }else if(layoutId.equalsIgnoreCase("30-60-30")){
        	viewValueSchema = viewValue+"<div class='row-fluid'><div class='span3' id='column-"+ ++countId +"'></div><div class='span6' id='column-"+ ++countId +"'></div><div class='span3' id='column-"+ ++countId +"'></div></div>";
        }else if(layoutId.equalsIgnoreCase("40-40-40")){
        	viewValueSchema = viewValue+"<div class='row-fluid'><div class='span4' id='column-"+ ++countId +"'></div><div class='span4' id='column-"+ ++countId +"'></div><div class='span4' id='column-"+ ++countId +"'></div></div>";
        }else if(layoutId.equalsIgnoreCase("80-40")){
        	viewValueSchema = viewValue+"<div class='row-fluid'><div class='span8' id='column-"+ ++countId +"'></div><div class='span4' id='column-"+ ++countId +"'></div></div>";
        }else if(layoutId.equalsIgnoreCase("60-60-table")){
        	viewValueSchema = viewValue+"<div class='row-fluid'><div class='span12' id='column-"+ ++countId +"'><table class='table table-bordered'><tbody><tr><td id='column-"+countId+"-1' style='width: 50%;'></td><td id='column-"+countId+"-2'></td></tr></tbody></table></div></div>";
        }
        String viewStart = "\"view\": {\"parent\": \"bootstrap-edit\",\"layout\": { \"template\": \"<div class='row-fluid'>";
        String optionValue = ParamUtil.getString(actionRequest, "optionValue");
 		String sampleData = "";
 		Pattern patternName = Pattern.compile("\"name\": \"(.*?)\"");
        Matcher matcherName = patternName.matcher(optionValue);
        while(matcherName.find())
        {
        	sampleData += "\""+matcherName.group(1)+"\":\"column-1\"," ;
        }
        String sampSOS = "";
 		if(sampleData.contains(",")){
 			sampSOS = sampleData.trim().substring(0, sampleData.trim().length()-1);
 		}
        String viewEnd = "</div>\",\"bindings\": {";
        String viewEnd2 = "}},\"fields\": {";
        String fieldsContent = "";
        if(Validator.isNotNull(isArray) && isArray.equalsIgnoreCase("true")){
        	fieldsContent = fieldLayout;
        }
        String viewEnd3 = "}}";
		JSONObject jsonObject = JSONFactoryUtil
				.createJSONObject();
		
		jsonObject
		.put("countId", countId);
		jsonObject
				.put("editorLayout", viewStart+ viewValueSchema +viewEnd+sampSOS+viewEnd2 +fieldsContent +viewEnd3);
		jsonObject
				.put("viewValue", viewValueSchema);
		writeJSON(actionRequest, actionResponse, jsonObject);
	}	
	public void buildJsonFormUpdate(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, JSONException {
		// TODO Auto-generated method stub
		
		 String updateForm = ParamUtil.getString(actionRequest, "updateForm");
//         System.out.println("**updateForm**"+updateForm);
         
         org.json.JSONObject jsonSampleData = new org.json.JSONObject(updateForm);
         org.json.JSONObject schema = jsonSampleData.getJSONObject("schema");
         org.json.JSONObject properties = schema.getJSONObject("properties");
         org.json.JSONObject options = jsonSampleData.getJSONObject("options");
         org.json.JSONObject fields = options.getJSONObject("fields");
         org.json.JSONObject view = jsonSampleData.getJSONObject("view");
         org.json.JSONObject layout = view.getJSONObject("layout");
         String template = layout.getString("template");
//         System.out.println("properties" + properties.toString().trim().substring(1,properties.toString().trim().length()-1));
//         System.out.println("fields" + fields.toString().trim().substring(1,fields.toString().trim().length()-1));
//         System.out.println("template" + template);
//         System.out.println("schema.toString()" + "schema:" +schema.toString());
		JSONObject jsonObject = JSONFactoryUtil
				.createJSONObject();
		
		jsonObject
				.put("editorDKParam", "schema:" + schema.toString());
		jsonObject
				.put("editor", "options:" + options.toString());
		jsonObject
				.put("schemaValue", properties.toString().trim().substring(1,properties.toString().trim().length()-1));
		jsonObject
				.put("optionValue", fields.toString().trim().substring(1,fields.toString().trim().length()-1));
		jsonObject
				.put("editorLayout", "view:" + view.toString());
		jsonObject
				.put("viewValue", template);
		writeJSON(actionRequest, actionResponse, jsonObject);
	}	
	public void previewAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, JSONException {
		// TODO Auto-generated method stub
		
		 String alpacaSchema = ParamUtil.getString(actionRequest, "alpacaSchema");
//         System.out.println("**alpacaSchema**"+"{"+alpacaSchema+"}");
         
        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
// 		httpRequest.getSession().invalidate();
 		httpRequest.getSession().setAttribute("alpacaSchema", "{"+alpacaSchema+"}");
 		
 		String jasperHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
 				+ "<jasperReport xmlns=\"http://jasperreports.sourceforge.net/jasperreports\" "
 				+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
 				+ "xsi:schemaLocation=\"http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd\" "
 				+ "name=\"openCPSGenJasper\" pageWidth=\"595\" pageHeight=\"842\" columnWidth=\"555\" leftMargin=\"20\" rightMargin=\"20\" "
 				+ "topMargin=\"20\" bottomMargin=\"20\" whenResourceMissingType=\"Empty\" "
 				+ "uuid=\""+PortalUUIDUtil.generate()+"\"><property name=\"ireport.zoom\" value=\"1.4641000000000006\"/>"
 						+ "<property name=\"ireport.x\" value=\"0\"/>"
 						+ "<property name=\"ireport.y\" value=\"288\"/>"
 						+ "<property name=\"com.jaspersoft.studio.data.defaultdataadapter\" value=\"One Empty Record\"/>"
 						+ "<property name=\"net.sf.jasperreports.awt.ignore.missing.font\" value=\"true\"/>"
 						+ "<property name=\"net.sf.jasperreports.json.date.pattern\" value=\"yyyy-MM-dd\"/>"
 						+ "<property name=\"net.sf.jasperreports.json.number.pattern\" value=\"#,##0.##\"/>"
 						+ "<property name=\"ireport.background.image.properties\" value=\"false,true,0.25,0,0,0,0,0,0\"/>"
 						+ "<style name=\"Sans_Normal\" isDefault=\"true\" fontName=\"DejaVu Sans\" fontSize=\"12\" isBold=\"false\" isItalic=\"false\" isUnderline=\"false\" isStrikeThrough=\"false\"/>"
 						+ "<style name=\"Sans_Bold\" fontName=\"DejaVu Sans\" fontSize=\"12\" isBold=\"true\" isItalic=\"false\" isUnderline=\"false\" isStrikeThrough=\"false\"/>"
 						+ "<style name=\"Sans_Italic\" fontName=\"DejaVu Sans\" fontSize=\"12\" isBold=\"false\" isItalic=\"true\" isUnderline=\"false\" isStrikeThrough=\"false\"/>"
 						+ "<queryString language=\"json\"><![CDATA[opencps]]></queryString>";
 		String jasperParam = "";
 		String jasperStaticText = "";
 		String sampleStrat = "{";
 		String sampleData = "";
 		String sampleEnd = "}";
 		Pattern patternName = Pattern.compile("\"name\": \"(.*?)\"");
        Matcher matcherName = patternName.matcher("{"+alpacaSchema+"}");
        while(matcherName.find())
        {
        	sampleData += "\""+matcherName.group(1)+"\":\"\"," ;
        	jasperParam += "<field name=\""+matcherName.group(1)+"\" class=\"java.lang.String\"><fieldDescription><![CDATA["+matcherName.group(1)+"]]></fieldDescription></field>";
        }
        Pattern patternLabel = Pattern.compile("\"label\": \"(.*?)\"");
        Matcher matcherLabel = patternLabel.matcher("{"+alpacaSchema+"}");
        int y = 150;
        jasperStaticText = "<band height=\"222\"><staticText>"
        		+ "<reportElement positionType=\"Float\" x=\"227\" y=\"7\" width=\"292\" height=\"19\" uuid=\""+PortalUUIDUtil.generate()+"\"/>"
        		+ "<textElement textAlignment=\"Center\" verticalAlignment=\"Middle\">"
        		+ "<font fontName=\"DejaVu Sans\" size=\"14\" isBold=\"true\"/>"
        		+ "</textElement><text><![CDATA[CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM]]></text>"
        		+ "</staticText>"
        		+ "<staticText>"
        		+ "<reportElement positionType=\"Float\" x=\"287\" y=\"26\" width=\"186\" height=\"19\" uuid=\""+PortalUUIDUtil.generate()+"\"/>"
        		+ "<box><bottomPen lineWidth=\"1.0\"/></box>"
        		+ "<textElement textAlignment=\"Center\" verticalAlignment=\"Middle\" rotation=\"None\">"
        		+ "<font fontName=\"DejaVu Sans\" size=\"12\" isBold=\"true\" isUnderline=\"false\"/>"
        		+ "<paragraph lineSpacing=\"Single\"/>"
        		+ "</textElement><text><![CDATA[Độc lập - Tự do -  Hạnh phúc]]></text>"
        		+ "</staticText>"
        		+ "<staticText>"
        		+ "<reportElement x=\"45\" y=\"81\" width=\"474\" height=\"33\" uuid=\""+PortalUUIDUtil.generate()+"\"/>"
        		+ "<textElement textAlignment=\"Center\" verticalAlignment=\"Middle\">"
        		+ "<font fontName=\"DejaVu Sans\" size=\"14\" isBold=\"true\"/>"
        		+ "</textElement><text><![CDATA[TÊN ĐƠN]]></text>"
        		+ "</staticText>"
        		+ "<staticText>"
        		+ "<reportElement positionType=\"Float\" x=\"282\" y=\"163\" width=\"237\" height=\"21\" uuid=\""+PortalUUIDUtil.generate()+"\"/>"
        		+ "<textElement textAlignment=\"Center\" verticalAlignment=\"Top\" markup=\"html\">"
        		+ "<font fontName=\"DejaVu Sans\" size=\"10\"/>"
        		+ "</textElement><text><![CDATA[(Ký tên và đóng dấu)]]></text>"
        		+ "</staticText>"
        		+ "<staticText>"
        		+ "<reportElement positionType=\"Float\" x=\"282\" y=\"141\" width=\"237\" height=\"22\" uuid=\""+PortalUUIDUtil.generate()+"\"/>"
        		+ "<textElement textAlignment=\"Center\" verticalAlignment=\"Middle\" markup=\"html\">"
        		+ "<font fontName=\"DejaVu Sans\" size=\"12\" isBold=\"true\"/>"
        		+ "</textElement><text><![CDATA[THỦ TRƯỞNG DOANH NGHIỆP]]></text>"
        		+ "</staticText>"
        		+ "<textField>"
        		+ "<reportElement x=\"45\" y=\"57\" width=\"474\" height=\"20\" isPrintWhenDetailOverflows=\"true\" uuid=\""+PortalUUIDUtil.generate()+"\"/>"
        		+ "<textElement textAlignment=\"Right\">"
        		+ "<font fontName=\"DejaVu Sans\" size=\"12\"/>"
        		+ "</textElement><textFieldExpression><![CDATA[\", \"]]></textFieldExpression>"
        		+ "</textField>"
        		+ "<textField isStretchWithOverflow=\"true\">"
        		+ "<reportElement x=\"45\" y=\"112\" width=\"474\" height=\"27\" isPrintWhenDetailOverflows=\"true\" uuid=\""+PortalUUIDUtil.generate()+"\"/>"
        		+ "<textElement textAlignment=\"Center\" verticalAlignment=\"Middle\" markup=\"none\">"
        		+ "<font fontName=\"DejaVu Sans\" size=\"12\" isBold=\"false\"/>"
        		+ "</textElement><textFieldExpression><![CDATA[\"Kính gửi: \"]]></textFieldExpression>"
        		+ "</textField>"
        		+ "<textField><reportElement positionType=\"Float\" x=\"17\" y=\"7\" width=\"186\" height=\"19\" isPrintWhenDetailOverflows=\"true\" uuid=\""+PortalUUIDUtil.generate()+"\"/>"
        		+ "<box><bottomPen lineWidth=\"1.0\"/></box>"
        		+ "<textElement textAlignment=\"Center\" verticalAlignment=\"Middle\" rotation=\"None\" markup=\"none\">"
        		+ "<font fontName=\"DejaVu Sans\" size=\"12\" isBold=\"true\" isUnderline=\"false\"/><paragraph lineSpacing=\"Single\"/></textElement>"
        		+ "</textField>"
        		+ "<textField><reportElement x=\"419\" y=\"184\" width=\"100\" height=\"30\" uuid=\""+PortalUUIDUtil.generate()+"\">"
        		+ "<property name=\"com.jaspersoft.studio.unit.width\" value=\"pixel\"/></reportElement>"
        		+ "<textElement><font size=\"1\"/></textElement>"
        		+ "<textFieldExpression><![CDATA[\"#\"]]></textFieldExpression>"
        		+ "</textField></band>";
        String fieldBrand = "";
        while(matcherLabel.find())
        {
        	fieldBrand += "<band height=\"22\"><property name=\"com.jaspersoft.studio.unit.height\" value=\"pixel\"/><textField isStretchWithOverflow=\"true\" isBlankWhenNull=\"true\"><reportElement x=\"0\" y=\"0\" width=\"555\" height=\"22\" isPrintWhenDetailOverflows=\"true\" uuid=\""+PortalUUIDUtil.generate()+"\"><property name=\"com.jaspersoft.studio.unit.height\" value=\"pixel\"/></reportElement><textElement textAlignment=\"Justified\"><font fontName=\"DejaVu Sans\" size=\"12\"/><paragraph firstLineIndent=\"40\"/></textElement><textFieldExpression><![CDATA[\""+matcherLabel.group(1).replaceAll("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;", "")+"\"]]></textFieldExpression></textField></band>";
        	
        }
        String isArray = (String)httpRequest.getSession().getAttribute("isArray");
        String nameArray = (String)httpRequest.getSession().getAttribute("nameArray");
        System.out.println("BuildFormAction.previewAction()"+isArray);
        if(Validator.isNotNull(isArray) && isArray.equalsIgnoreCase("true")){
//        	jasperHeader += "<subDataset name=\"openCPSSubDataSet\" uuid=\""+PortalUUIDUtil.generate()+"\"><property name=\"com.jaspersoft.studio.data.defaultdataadapter\" value=\"One Empty Record\"/><queryString language=\"json\"><![CDATA["+nameArray+"]]></queryString></subDataset>";
        	fieldBrand +="<band height=\"50\" splitType=\"Stretch\"><property name=\"com.jaspersoft.studio.unit.height\" value=\"pixel\"/><componentElement><reportElement x=\"40\" y=\"0\" width=\"471\" height=\"50\" uuid=\""+PortalUUIDUtil.generate()+"\"/><jr:list xmlns:jr=\"http://jasperreports.sourceforge.net/jasperreports/components\" xsi:schemaLocation=\"http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd\" printOrder=\"Vertical\"><datasetRun subDataset=\"openCPSSubDataSet\" uuid=\""+PortalUUIDUtil.generate()+"\"><dataSourceExpression><![CDATA[((net.sf.jasperreports.engine.data.JsonDataSource)$P{REPORT_DATA_SOURCE}).subDataSource(\""+nameArray+"\")]]></dataSourceExpression></datasetRun><jr:listContents height=\"50\" width=\"471\"></jr:listContents></jr:list></componentElement></band>";
        }
 		String jasperContent = "<detail>";
 		String jasperFooter = "</detail></jasperReport>";
 		httpRequest.getSession().setAttribute("jasperInit", jasperHeader + jasperParam + jasperContent+jasperStaticText+fieldBrand+jasperFooter);
 		String sampSOS = "";
 		if(sampleData.contains(",")){
 			sampSOS = sampleData.trim().substring(0, sampleData.trim().length()-1);
 		}
 		httpRequest.getSession().setAttribute("sampleData", sampleStrat + sampSOS + sampleEnd);
		JSONObject jsonObject = JSONFactoryUtil
				.createJSONObject();
		
		jsonObject
				.put("editorDKParam", "schema:");
		writeJSON(actionRequest, actionResponse, jsonObject);
	}
	private void writeJSON(
		    ActionRequest actionRequest, ActionResponse actionResponse, Object json)
		    throws IOException {

			HttpServletResponse response = PortalUtil
			    .getHttpServletResponse(actionResponse);

			response
			    .setContentType(ContentTypes.APPLICATION_JSON);

			ServletResponseUtil
			    .write(response, json
			        .toString());
			response
			    .flushBuffer();

		}
	
	public static Map<String, Object> jsonToMap(org.json.JSONObject json) {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if(json != org.json.JSONObject.NULL) {
            try {
				retMap = toMap(json);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return retMap;
    }

    public static Map<String, Object> toMap(org.json.JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof org.json.JSONObject) {
                value = toMap((org.json.JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof org.json.JSONObject) {
                value = toMap((org.json.JSONObject) value);
            }
            list.add(value);
        }
        return list;
}
    
    public static void main(String[] args) {
    	 String mydata = "\"label\" : \"the data i want inside\" \"label\" : \"the data2222222222222222222222\"";
         Pattern pattern = Pattern.compile("\"label\" : \"(.*?)\"");
         Matcher matcher = pattern.matcher(mydata);
         while(matcher.find())
         {
             System.out.println(matcher.group(1));
         }

    }
}
