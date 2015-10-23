<%@ page import="com.marketshare.commons.reports.Report" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName" value="${message(code: 'report.label', default: 'Report')}" />
<title><g:message code="default.create.label" args="[entityName]" /></title>

    <script type="text/javascript">

var urlCount=1;
function dashboardReportSection(){
    if(document.getElementById("reportType").value=="DASHBOARD_REPORT"){
        document.getElementById("reportSection").value="Scenario Overview";
        document.getElementById("reportSection").disabled=true;
        document.getElementById("height").style.display="none";
        document.getElementById("expandedUrl").style.display="table-row";
        for(var i=2;i<=urlCount;i++){
            document.getElementById("urlLabel"+i).style.display="inline-flex";
            document.getElementById("url_"+i).style.display="inline-flex";
            document.getElementById("heightLabel"+i).style.display="none";
            document.getElementById("height_"+i).style.display="none";
            document.getElementById("pxLabel"+i).style.display="none";
        }
    }
    else{
        document.getElementById("reportSection").disabled=false;
        document.getElementById("reportSection").value="Business Performance";
        document.getElementById("height").style.display="table-row";
        document.getElementById("expandedUrl").style.display="none";
        for(i=2;i<=urlCount;i++){
            document.getElementById("urlLabel"+i).style.display="none";
            document.getElementById("url_"+i).style.display="none";
            document.getElementById("heightLabel"+i).style.display="inline-flex";
            document.getElementById("height_"+i).style.display="inline-flex";
            document.getElementById("pxLabel"+i).style.display="inline-flex";
        }
    }
}
function scenarioReportType(){
    if(document.getElementById("reportSection").value=="Scenario Overview"){
        document.getElementById("reportType").value="DASHBOARD_REPORT";
        document.getElementById("reportSection").disabled=true;
        document.getElementById("height").style.display="none";
        document.getElementById("expandedUrl").style.display = "table-row"
        for(var i=2;i<=urlCount;i++){
            document.getElementById("heightLabel"+i).style.display="none";
            document.getElementById("height_"+i).style.display="none";
            document.getElementById("pxLabel"+i).style.display="none";
            document.getElementById("urlLabel" + i).style.display = "inline-flex";
            document.getElementById("url_" + i).style.display = "inline-flex";
        }
    }
    else{
        document.getElementById("reportSection").disabled=false;
        document.getElementById("height").style.display="table-row";
        document.getElementById("expandedUrl").style.display="none";
        for(i=2;i<=urlCount;i++){
            document.getElementById("urlLabel"+i).style.display="none";
            document.getElementById("url_"+i).style.display="none";
            document.getElementById("heightLabel"+i).style.display="inline-flex";
            document.getElementById("height_"+i).style.display="inline-flex";
            document.getElementById("pxLabel"+i).style.display="inline-flex";
        }
    }
}
function addElement()
        {
            urlCount = urlCount + 1;

            if(parseInt(urlCount) > parseInt('${localeListSize}') ) {
                alert("Only "+ '${localeListTemp}' +" locales supported ")
                return false
            }
            else{
                var localeListTemp = new Array();
                localeListTemp= new Array('${localeListTemp}');
                var localeList = localeListTemp.toString();
                localeList = localeList.replace("[","");
                localeList = localeList.replace("]","");
                localeList = localeList.replace(/ /g,"");
                localeList = localeList.replace(", ",",");
                localeList = localeList.replace(" , ",",");
                localeList = localeList.replace(" ,",",");
                localeList = localeList.split(",");

                var contentID = document.getElementById('locales');


                var loCaleLabel = document.createElement('label');
                loCaleLabel.innerHTML = "<b>LOCALE             </b>";
                loCaleLabel.style.display = "inline-flex";
                loCaleLabel.style.width = "225px";

                var newDiv = document.createElement('div');
                newDiv.appendChild(loCaleLabel);

                var selectElement = document.createElement("select");
                selectElement.setAttribute("name",'localeName'+urlCount);

                for(var k=0; k<'${localeListSize}'; k++){

                    selectElement.options[k] = new Option(localeList[k],localeList[k]);
                    newDiv.appendChild(selectElement);
                }
                selectElement.selectedIndex = urlCount-1;
                contentID.appendChild(newDiv);

                var nameLabel = document.createElement('label');
                nameLabel.innerHTML = "<b>NAME</b>";
                nameLabel.style.display = "inline-flex";
                nameLabel.style.width = "225px";

                var newDiv3Text = document.createElement('input');
                newDiv3Text.setAttribute('id','name_'+urlCount);
                newDiv3Text.setAttribute('name','name'+urlCount);
                newDiv3Text.setAttribute('required','');
                newDiv3Text.setAttribute('type','text');
                newDiv3Text.setAttribute('maxlength','100');

                var newDiv3 = document.createElement('div');
                newDiv3.appendChild(nameLabel);
                newDiv3.appendChild(newDiv3Text);
                contentID.appendChild(newDiv3);


                var DescriptionLabel = document.createElement('label');
                DescriptionLabel.innerHTML = "<b>LONG TITLE</b>";
                DescriptionLabel.style.display = "inline-flex";
                DescriptionLabel.style.width = "225px";

                var newDiv4Text = document.createElement('input');
                newDiv4Text.setAttribute('id','description_'+urlCount);
                newDiv4Text.setAttribute('name','description'+urlCount);
                newDiv4Text.setAttribute('required','');
                newDiv4Text.setAttribute('type','textArea');
                newDiv4Text.setAttribute('maxlength','200');

                var newDiv4 = document.createElement('div');
                newDiv4.appendChild(DescriptionLabel);
                newDiv4.appendChild(newDiv4Text);
                contentID.appendChild(newDiv4);


                var miniUrlLabel = document.createElement('label');
                miniUrlLabel.innerHTML = "<b>URL</b>";
                miniUrlLabel.style.display = "inline-flex";
                miniUrlLabel.style.width = "225px";

                var newDiv1Text = document.createElement('input');
                newDiv1Text.setAttribute('id','miniUrl_'+urlCount);
                newDiv1Text.setAttribute('name','miniUrl'+urlCount);
                newDiv1Text.setAttribute('required','');
                newDiv1Text.setAttribute('type','text');
                newDiv1Text.setAttribute('maxlength','500');

                var newDiv1 = document.createElement('div');
                newDiv1.appendChild(miniUrlLabel);
                newDiv1.appendChild(newDiv1Text);
                contentID.appendChild(newDiv1);


                var urlLabel = document.createElement('label');
                urlLabel.innerHTML = "<b>EXPANDED URL</b>";
                urlLabel.style.display = "inline-flex";
                urlLabel.style.width = "225px";
                urlLabel.id = 'urlLabel'+urlCount;

                var newDiv2Text = document.createElement('input');
                newDiv2Text.setAttribute('id','url_'+urlCount);
                newDiv2Text.setAttribute('name','url'+urlCount);
                newDiv2Text.setAttribute('type','text');
                newDiv2Text.setAttribute('maxlength','500');

                if(document.getElementById("reportType").value!="DASHBOARD_REPORT"){
                    urlLabel.style.display="none";
                    newDiv2Text.style.display="none";
                }

                var newDiv2 = document.createElement('div');
                newDiv2.appendChild(urlLabel);
                newDiv2.appendChild(newDiv2Text);
                contentID.appendChild(newDiv2);

                var height = document.createElement('label');
                height.innerHTML = "<b>REPORT HEIGHT PX</b>";
                height.style.display = "inline-flex";
                height.style.width = "225px";
                height.id='heightLabel'+urlCount;

                var newDivInteger = document.createElement('input');
                newDivInteger.setAttribute('id','height_'+urlCount);
                newDivInteger.setAttribute('name','height'+urlCount);
                newDivInteger.setAttribute('type','number');
                newDivInteger.setAttribute('min','1');
                newDivInteger.setAttribute('max','2147483647');

                var pxLabel = document.createElement('label');
                pxLabel.innerHTML = "<b>&nbsp;(1000 px if blank)</b>";
                pxLabel.style.display = "inline-flex";
                pxLabel.style.width = "225px";
                pxLabel.id='pxLabel'+urlCount;

                var divInt = document.createElement('div');
                divInt.appendChild(height);
                divInt.appendChild(newDivInteger);
                divInt.appendChild(pxLabel);
                contentID.appendChild(divInt);




                return false ;
            }
        }



</script>
</head>
<body>
<div id="pagetitle">
<div class="wrapper">
<div>
<g:link class="cmdlink" action="list">List Reports</g:link>
            <g:link class="cmdlink" action="create">New Report</g:link>
<g:link class="cmdlink" action="saveReportConfig">Common Report Settings</g:link>
        </div>
</div>
</div>
<div id="pageBody">
<div class="wrapper">
<section class="column width8 first">
<g:if test="${flash.message}">
<div class="message">${flash.message}</div>
            </g:if>
<g:hasErrors bean="${reportInstance}">
<div class="errors">
<g:renderErrors bean="${reportInstance}" as="list" />
</div>
            </g:hasErrors>
<fieldset>
<legend>
<g:message code="default.create.label" args="[entityName]" />
</legend>
                <g:form name="myform" action="save" useToken="true">
                    <div class="dialog">
                        <table>
                            <tbody>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="reportOrderId"><g:message code="report.reportOrderId.label" default="Report Order" /></label>
                                </td>
<td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'reportOrderId', 'errors')}">
<g:field type="number" name="reportOrderId" min="1" max="50" required="" />
</td>
                            </tr>

<tr class="prop"  >
<td valign="top" class="name"  >
<label for="reportType" ><g:message code="report.tableauReportURL.reportType" default="Report Type" /></label>
                                </td>
%{--<td valign="top">k
    <g:radioGroup name="reportType" labels="['DashBoard Report','V4 Reporting','Others']" values="['DASHBOARD_REPORT','TABLEAU']" value = 'DASHBOARD_REPORT'>
    <span>${it.radio} ${it.label}</span>
                                    </g:radioGroup>
    </td>--}%
                                <td valign="top" class="value">
                                    <g:select  name="reportType" from="${chartTypes}" onchange="dashboardReportSection()" id="reportType"/>
    </td>
                            </tr>

    <tr class="prop">
    <td valign="top"  class="name" >
    <label for="reportSection"><g:message code="report.reportSection.label" default="Report Section" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'reportOrderId', 'errors')}">
    <g:select  name="reportSection" from="${reportSectionList}"  onchange="scenarioReportType()" id="reportSection"/>
    </td>

                            </tr>

    <tr class="prop">
    <td valign="top"  class="name" >
    <label for="isAdminOnly"><g:message code="report.reportSection.label" default="ADMIN ONLY" /></label>
                                </td>
    <td valign="top" class="value >
    <g:checkBox name="isAdminOnly" value="${isAdminOnly}"/>
    </td>

                            </tr>

    <tr class="prop">
    <td valign="top" class="name">
    <label for="localeDefault"><g:message code="report.tableauReportURL.label" default="LOCALE" /></label>
                                </td>
    <td valign="top" class="value">
    <g:select  name="localeDefault" from="${localeListTemp}" />

    </td>

                            </tr>


    %{--<tr class="prop">
        <td valign="top" class="name">
        <label for="localeDefault"><g:message code="report.tableauReportURL.label" default="  " /></label>
                                </td>
        <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'tableauReportURL', 'errors')}">
        <g:textField name="localeDefault"  value ="en"/>
        </td>
                            </tr>--}%

            <tr class="prop">
    <td valign="top" class="name">
    <label for="name"><g:message code="report.name.label" default="Name" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'name', 'errors')}">
    <g:textField name="name" maxlength="100" required="" />
    </td>
                            </tr>


    <tr class="prop">
    <td valign="top" class="name">
    <label for="description"><g:message code="report.description.label" default="Long Title" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'description', 'errors')}">
    <g:textField name="description" maxlength="200" required=""/>
    </td>
                            </tr>


    <tr class="prop">
    <td valign="top" class="name">
    <label for="tableauReportURL"><g:message code="report.tableauReportURL.label" default="URL" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'tableauReportURL', 'errors')}">
    <g:textField name="tableauReportMiniURL"  maxlength="500"  required="" />
    </td>
                            </tr>

    <tr class="prop" id="expandedUrl" style="display: none">
    <td valign="top" class="name">
    <label for="tableauReportURL"><g:message code="report.tableauReportURL.label" default="Expanded URL" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'tableauReportURL', 'errors')}">
    <g:textField name="tableauReportURL" maxlength="500" />
    </td>

                            </tr>

    <tr class="prop" id="height">
    <td valign="top" class="name">
    <label for="height"><g:message code="report.height.label" default="REPORT HEIGHT PX" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'tableauReportURL', 'errors')}">
    <g:field min="1" max="2147483647" type="number" name="height"  />
    <label ><g:message code="report.default.label" default="(1000 px if blank)" /></label>
                                </td>

    </tr>



                            </tbody>
    </table>
                    </div>

    <div class="box">
    <div id="locales">

    <td valign="top" >
    <button onclick="addElement(); dashboardReportSection();">Add Url for different locale</button>
                            </td>

    </div>
                    </div>

    <div class="box">

    <span class="button"><g:actionSubmit
    class="btn btn-green big" action="save"
    value="${message(code: 'default.button.save.label', default: 'Save')}" />
    </span>
                    </div>


    </g:form>


            </fieldset>
    </div>
</section>
    </div>
</body>
    </html>
