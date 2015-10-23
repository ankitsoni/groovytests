<%@ page import="com.marketshare.commons.reports.Report" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName" value="${message(code: 'report.label', default: 'Report')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>


<style type="text/css">
.name {
    display: block;
    float: left;
    width : 200px;
}
</style>

<script type="text/javascript">

var urlCount=parseInt('${reportUrlListSize}');
function dashboardReportSection(){
    if(document.getElementById("reportType").value=="DASHBOARD_REPORT"){
        document.getElementById("reportSection").value="Scenario Overview";
        document.getElementById("reportSection").disabled=true;
        for(var i=0;i<=urlCount;i++){
            if(i!=parseInt('${reportUrlListSize}')){
                document.getElementById("urlLabel"+i).style.display="inline-flex";
                document.getElementById("url_"+i).style.display="inline-flex";
                document.getElementById("heightLabel"+i).style.display="none";
                document.getElementById("height_"+i).style.display="none";
                document.getElementById("pxLabel"+i).style.display="none";
            }
        }
    }
    else{
        document.getElementById("reportSection").disabled=false;
        for(i=0;i<=urlCount;i++){
            if(i!=parseInt('${reportUrlListSize}')){
                document.getElementById("urlLabel"+i).style.display="none";
                document.getElementById("url_"+i).style.display="none";
                document.getElementById("heightLabel"+i).style.display="inline-flex";
                document.getElementById("height_"+i).style.display="inline-flex";
                document.getElementById("pxLabel"+i).style.display="inline-flex";
            }
        }
    }
}
function scenarioReportType(){
    if(document.getElementById("reportSection").value=="Scenario Overview"){
        document.getElementById("reportType").value="DASHBOARD_REPORT";
        document.getElementById("reportSection").disabled=true;
        for(var i=2;i<=urlCount;i++){
            if(i!=parseInt('${reportUrlListSize}')) {
                document.getElementById("heightLabel" + i).style.display = "none";
                document.getElementById("height_" + i).style.display = "none";
                document.getElementById("pxLabel" + i).style.display = "none";
                document.getElementById("urlLabel"+i).style.display="inline-flex";
                document.getElementById("url_"+i).style.display="inline-flex";
            }
        }
    }else{
        document.getElementById("reportSection").disabled=false;
        for(i=2;i<=urlCount;i++){
            if(i!=parseInt('${reportUrlListSize}')){
                document.getElementById("urlLabel"+i).style.display="none";
                document.getElementById("url_"+i).style.display="none";
                document.getElementById("heightLabel"+i).style.display="inline-flex";
                document.getElementById("height_"+i).style.display="inline-flex";
                document.getElementById("pxLabel"+i).style.display="inline-flex";
            }
        }

    }

}

function addElementEdit()
        {

            urlCount = urlCount + 1;
            if(parseInt(urlCount) > parseInt('${localeListSize}') || ( parseInt('${reportUrlListSize}')== parseInt('${localeListSize}')) ) {
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
                loCaleLabel.innerHTML = "<b>LOCALE      </b>";
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
                newDiv4Text.setAttribute('type','text');
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
                urlLabel.id='urlLabel'+urlCount;

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
                newDivInteger.setAttribute('min',1);
                newDivInteger.setAttribute('max',2147483647);

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
            dashboardReportSection()
        }

function addExistingData()
        {


            var reportLocaleTemp = new Array("${reportLocale}");
            var reportLocale  = reportLocaleTemp.toString();
            reportLocale = reportLocale.replace("[","");
            reportLocale = reportLocale.replace("]","");
            reportLocale = reportLocale.replace(/ /g,"");
            reportLocale = reportLocale.replace(", ",",");
            reportLocale = reportLocale.replace(" , ",",");
            reportLocale = reportLocale.replace(" ,",",");
            reportLocale = reportLocale.split(",");

            var reportUrlTemp = new Array("${reportUrl}");
            var reportUrl  = reportUrlTemp.toString();
            reportUrl = reportUrl.replace("[","");
            reportUrl = reportUrl.replace("]","");
            reportUrl = reportUrl.replace(/, /g,",");
            reportUrl = reportUrl.replace(", ",",");
            reportUrl = reportUrl.replace(" , ",",");
            reportUrl = reportUrl.replace(" ,",",");
            reportUrl = reportUrl.split(",");

            var reportMiniUrlTemp = new Array("${reportMiniUrl}");
            var reportMiniUrl  = reportMiniUrlTemp.toString();
            reportMiniUrl = reportMiniUrl.replace("[","");
            reportMiniUrl = reportMiniUrl.replace("]","");
            reportMiniUrl = reportMiniUrl.replace(/, /g,",");
            reportMiniUrl = reportMiniUrl.replace(", ",",");
            reportMiniUrl = reportMiniUrl.replace(" , ",",");
            reportMiniUrl = reportMiniUrl.replace(" ,",",");
            reportMiniUrl = reportMiniUrl.split(",");

            var reportNameTemp = new Array("${reportName}");
            var reportName  = reportNameTemp.toString();
            reportName = reportName.replace("[","");
            reportName = reportName.replace("]","");
            //reportName = reportName.replace(" ","");
            reportName = reportName.replace(/, /g,",");
            reportName = reportName.replace(", ",",");
            reportName = reportName.replace(" , ",",");
            reportName = reportName.replace(" ,",",");
            reportName = reportName.split(",");

            var reportDescriptionTemp = new Array("${reportDescription}");
            var reportDescription  = reportDescriptionTemp.toString();
            reportDescription = reportDescription.replace("[","");
            reportDescription = reportDescription.replace("]","");
            //reportDescription = reportDescription.replace(" ","");
            reportDescription = reportDescription.replace(/, /g,",");
            reportDescription = reportDescription.replace(", ",",");
            reportDescription = reportDescription.replace(" , ",",");
            reportDescription = reportDescription.replace(" ,",",");
            reportDescription = reportDescription.split(",");

            var reportHeightTemp = new Array("${reportHeight}");
            var reportHeights = reportHeightTemp.toString();
            reportHeights = reportHeights.replace("[","");
            reportHeights = reportHeights.replace("]","");
            //reportHeight = reportHeight.replace(" ","");
            reportHeights = reportHeights.replace(/, /g,",");
            reportHeights = reportHeights.replace(", ",",");
            reportHeights = reportHeights.replace(" ,",",");
            reportHeights = reportHeights.split(",");

            var localeListTemp= new Array("${localeListTemp}");
            var localeList = localeListTemp.toString();
            localeList = localeList.replace("[","");
            localeList = localeList.replace("]","");
            localeList = localeList.replace(" ","");
            localeList = localeList.replace(/ /g,"");
            localeList = localeList.split(",");

            var contentID = document.getElementById('mainTab');

            for(var q =0 ; q<'${reportUrlListSize}'; q++){

                var loCaleLabel = document.createElement('label');
                loCaleLabel.innerHTML = "<b>LOCALE      </b>";
                loCaleLabel.style.display = "inline-flex";
                loCaleLabel.style.width = "200px";

                var newDiv = document.createElement('div');
                newDiv.appendChild(loCaleLabel);

                var selectElement = document.createElement("select");
                selectElement.setAttribute("name",'localeName'+q);
                //selectElement.disabled = true
                for(var k=0; k<'${localeListSize}'; k++){

                    selectElement.options[k] = new Option(localeList[k],localeList[k]);
                    newDiv.appendChild(selectElement);
                }

                for(var l=0; l<'${localeListSize}'; l++){
                    if(reportLocale[q] == selectElement.options[l].value){
                        selectElement.selectedIndex = l;
                    }
                }

                contentID.appendChild(newDiv);


                var nameLabel = document.createElement('label');
                nameLabel.innerHTML = "<b>NAME</b>";
                nameLabel.style.display = "inline-flex";
                nameLabel.style.width = "200px";

                var newDiv3Text = document.createElement('input');
                newDiv3Text.setAttribute('id','name_'+q);
                newDiv3Text.setAttribute('name','name'+q);
                newDiv3Text.setAttribute('required','');
                newDiv3Text.setAttribute('type','text');
                newDiv3Text.setAttribute('value',reportName[q]);
                newDiv3Text.setAttribute('maxlength','100');

                var newDiv3 = document.createElement('div');
                newDiv3.appendChild(nameLabel);
                newDiv3.appendChild(newDiv3Text);
                contentID.appendChild(newDiv3);


                var DescriptionLabel = document.createElement('label');
                DescriptionLabel.innerHTML = "<b>LONG TITLE</b>";
                DescriptionLabel.style.display = "inline-flex";
                DescriptionLabel.style.width = "200px";

                var newDiv4Text = document.createElement('input');
                newDiv4Text.setAttribute('id','description_'+q);
                newDiv4Text.setAttribute('name','description'+q);
                newDiv4Text.setAttribute('required','');
                newDiv4Text.setAttribute('type','text');
                newDiv4Text.setAttribute('value',reportDescription[q]);
                newDiv4Text.setAttribute('maxlength','200');

                var newDiv4 = document.createElement('div');
                newDiv4.appendChild(DescriptionLabel);
                newDiv4.appendChild(newDiv4Text);
                contentID.appendChild(newDiv4);


                var miniUrlLabel = document.createElement('label');
                miniUrlLabel.innerHTML = "<b>URL</b>";
                miniUrlLabel.style.display = "inline-flex";
                miniUrlLabel.style.width = "200px";

                var newDiv1Text = document.createElement('input');
                newDiv1Text.setAttribute('id','miniUrl_'+q);
                newDiv1Text.setAttribute('name','miniUrl'+q);
                newDiv1Text.setAttribute('type','text');
                newDiv1Text.setAttribute('required','');
                newDiv1Text.setAttribute('value',reportMiniUrl[q]);
                newDiv1Text.setAttribute('maxlength','500');

                var newDiv1 = document.createElement('div');
                newDiv1.appendChild(miniUrlLabel);
                newDiv1.appendChild(newDiv1Text);
                contentID.appendChild(newDiv1);


                var urlLabel = document.createElement('label');
                urlLabel.innerHTML = "<b>EXPANDED URL</b>";
                urlLabel.style.display = "inline-flex";
                urlLabel.style.width = "200px";
                urlLabel.id='urlLabel'+q;

                var newDiv2Text = document.createElement('input');
                newDiv2Text.setAttribute('id','url_'+q);
                newDiv2Text.setAttribute('name','url'+q);
                newDiv2Text.setAttribute('type','text');
                newDiv2Text.setAttribute('value',reportUrl[q]);
                newDiv2Text.setAttribute('maxlength','500');

                var newDiv2 = document.createElement('div');
                newDiv2.appendChild(urlLabel);
                newDiv2.appendChild(newDiv2Text);
                contentID.appendChild(newDiv2);

                var height = document.createElement('label');
                height.innerHTML = "<b>REPORT HEIGHT PX</b>";
                height.style.display = "inline-flex";
                height.style.width = "200px";
                height.id='heightLabel'+q;

                var newDivInteger = document.createElement('input');
                newDivInteger.setAttribute('id','height_'+q);
                newDivInteger.setAttribute('name','height'+q);
                newDivInteger.setAttribute('type','number');
                newDivInteger.setAttribute('min','1');
                newDivInteger.setAttribute('max','2147483647');
                newDivInteger.setAttribute('value',reportHeights[q]);

                var pxLabel = document.createElement('label');
                pxLabel.innerHTML = "<b> (1000 px if blank)</b>";
                pxLabel.style.display = "inline-flex";
                pxLabel.style.width = "225px";
                pxLabel.id='pxLabel'+q;

                var divInt = document.createElement('div');
                divInt.appendChild(height);
                divInt.appendChild(newDivInteger);
                divInt.appendChild(pxLabel);
                contentID.appendChild(divInt);

                var space = document.createElement('label');
                space.innerHTML = "<b>  </b>";
                space.style.display = "inline-flex";
                space.style.width = "231px";
                contentID.appendChild(space);

            }
            dashboardReportSection()
            return false ;
        }


</script>
</head>
<body>
<div id="pagetitle">
<div class="wrapper">
<g:link class="cmdlink" action="list">List Reports</g:link>
        <g:link class="cmdlink" action="create">New Report</g:link>
<g:link class="cmdlink" action="saveReportConfig">Common Report Settings</g:link>
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
<g:message code="default.edit.label" args="[entityName]" />
</legend>

                <g:form method="post" useToken="true" class="dialog11">
                    <g:hiddenField name="id" value="${reportInstance?.id}" />
<g:hiddenField name="version" value="${reportInstance?.version}" />
<div id="mainTab" class="dialog">
<table>
<tbody >

%{-- <tr class="prop" >
    <td valign="top" class="name">
    <label for="name"><g:message code="report.name.label" default="Name" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'name', 'errors')}">
    <g:textField name="name" maxlength="100" required="" value="${reportName[0]}" />
    </td>
                            </tr>--}%


        %{--<tr class="prop">
    <td valign="top" class="name">
    <label for="description"><g:message code="report.description.label" default="Description" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'description', 'errors')}">
    <g:textArea name="description" cols="40" rows="5" value="${reportInstance?.description}" />
    </td>
                            </tr>--}%



        <tr class="prop">
<td valign="top" class="name">
<label for="reportOrderId"><g:message code="report.reportOrderId.label" default="Report Order " /></label>
                                </td>
<td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'reportOrderId', 'errors')}">
<g:field type="number" name="reportOrderId" min="1" max="50" required="" value="${reportInstance?.reportOrderId}" />
</td>
                            </tr>



<tr class="prop">
<td valign="top" class="name">
<label for="reportType"><g:message code="report.tableauReportURL.reportType" default="Report Type" /></label>
                                </td>
%{--<td valign="top">
    <g:radioGroup name="reportType" labels="['DashBoard Report','V4 Reporting','Others']" values="['DASHBOARD_REPORT','TABLEAU']" value="${reportInstance?.reportType}">
    <span>${it.radio} ${it.label}</span>
                                    </g:radioGroup>
    </td>--}%
                                <td valign="top" class="value">
                                    <g:select  name="reportType" from="${chartTypes}" value="${reportInstance?.reportType}" id="reportType" onchange="dashboardReportSection()"  />
    </td>
                            </tr>


    <tr class="prop">
    <td valign="top" class="name">
    <label for="reportSection"><g:message code="report.reportSection.label" default="Report Section" /></label>
                                </td>
    <td valign="top" class="value">
    <g:select  name="reportSection"  from="${reportSectionList}" value="${reportSection}" id="reportSection" onchange="scenarioReportType()"/>
    </td>
                            </tr>

    <tr class="prop">
    <td valign="top"  class="name" >
    <label for="isAdminOnly"><g:message code="report.reportSection.label" default="ADMIN ONLY" /></label>
                                </td>
    <td valign="top" class="value >
    <g:checkBox name="isAdminOnly" value="${reportInstance.isAdminOnly}"/>
    </td>
                            </tr>


    <div id="locales1">



    </div>

                            <td valign="top" class="name">
                                <body  onload="addExistingData(); dashboardReportSection();"></body >
    </td>


                            %{--<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="localeDefault"><g:message code="report.tableauReportURL.label" default="Locale default : en" /></label>
                                </td>
    <td valign="top" class="value">
    <g:select  name="localeDefault" from="${localeListTemp}" />

    </td>

                            </tr>

    <tr class="prop">
    <td valign="top" class="name">
    <label for="tableauReportURL"><g:message code="report.tableauReportURL.label" default="Tableau Report Mini URL" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'tableauReportURL', 'errors')}">
    <g:textField name="tableauReportMiniURL" value="${reportUrlListTemp?.miniUrl}" />
    </td>
                            </tr>

    <tr class="prop">
    <td valign="top" class="name">
    <label for="tableauReportURL"><g:message code="report.tableauReportURL.label" default="Tableau Report Complete URL" /></label>
                                </td>
    <td valign="top" class="value ${hasErrors(bean: reportInstance, field: 'tableauReportURL', 'errors')}">
    <g:textField name="tableauReportURL" value="${reportUrlListTemp?.url}" />
    </td>
                            </tr>--}%

        </tbody>
                        </table>
</div>

                    <div class="box">

                        <div id="locales">

                            %{-- <td valign="top" >
                                <body  onload="addExistingData();"></body >
</td>--}%

                            <td valign="top" >
                                <button onclick="addElementEdit(); dashboardReportSection();">Add Url for different locale</button>
</td>

                        </div>
</div>


                    <div class="box">
                        <g:actionSubmit class="btn btn-green big" action="update"
                                        value="${message(code: 'default.button.save.label', default: 'update')}" redirect="list"/>
<g:actionSubmit class="btn btn-red" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
</div>


                </g:form>
</fieldset>
        </section>
</div>
</div>
</body>
</html>
