package com.marketshare.optimizer.data

import com.marketshare.commons.reports.Report
import com.marketshare.commons.reports.ReportParam
import com.marketshare.commons.reports.ReportSummaryConf
import com.marketshare.optimizer.Constants
import com.marketshare.commons.reports.ReportUrl
import com.marketshare.commons.auth.User
import com.marketshare.commons.i18n.Locale

class AdhocReportService {

    static transactional = false
    def userService

    def saveReport(def params){

        log.println("AdhocReportService.saveReport creating record : " +params)
        Report reportInst = new Report()
        reportInst.name = params.name ? params.name :""
        reportInst.code = ""
        reportInst.description = params.description ? params.description:"NA"
        reportInst.tableauReportMiniURL  = ""//params.tableauReportMiniURL ?  params.tableauReportMiniURL  :"NA"
        reportInst.tableauReportURL  = "" //params.tableauReportURL? params.tableauReportURL :"NA"
        reportInst.linkName = ""
        reportInst.level = null
        reportInst.reportOrderId = params.reportOrderId?params.reportOrderId.toInteger(): 100.toInteger()
        reportInst.showRelatedInsights = null
        reportInst.relatedInsightsOpen = null
        reportInst.isAdminOnly = params.isAdminOnly ? true : false
        reportInst.reportDirectory = ""
        if (params.reportType == Constants.reportType){
            reportInst.reportType = Constants.reportType
            reportInst.reportGroupId = null
        }
        else if (params.reportType == Constants.reportTypeTableau){
            reportInst.reportType = Constants.reportTypeTableau
            reportInst.reportGroupId = params.reportGroupId? params.reportGroupId.toLong() : null
        }else if (params.reportType == Constants.reportTypeArcadia){
            reportInst.reportType = Constants.reportTypeArcadia
            reportInst.reportGroupId = params.reportGroupId? params.reportGroupId.toLong() : null
        }
        /*reportInst.reportType = Constants.reportType*/
        reportInst.createdDate = new Date()

        reportInst.reportMetas = null;
        reportInst.save(failOnError: true, flush:true)

        ReportUrl reportUrlInst = new ReportUrl()
        def localeName = (params.localeDefault? params.localeDefault : "en").toString()
        reportUrlInst.name = params.name ? params.name :""
        reportUrlInst.description = params.description ? params.description:"NA"
        reportUrlInst.localeName = localeName
        reportUrlInst.localeId = com.marketshare.commons.i18n.Locale.findWhere(name : localeName)?.id.toLong()
        reportUrlInst.reportId = reportInst.id
        reportUrlInst.url =  reportInst.reportType == Constants.reportType ? (params.tableauReportURL? params.tableauReportURL :params.tableauReportMiniURL):null
        reportUrlInst.miniUrl = params.tableauReportMiniURL ?  params.tableauReportMiniURL  :"NA"
        reportUrlInst.height = reportInst.reportType==Constants.reportType ? null :(params.height ? params.height.toInteger() :1000.toInteger())
        reportUrlInst.save(failOnError: true, flush:true)

        for(Integer i = 2 ; i<= (params.size() - 8.toInteger()); i++){

            def localeName2 = "localeName"+i
            def url2 = "url"+i
            def name2 = "name"+i
            def description2 = "description"+i
            def miniUrl2 = "miniUrl"+i
            def height2 = "height"+i
            if(params.get(localeName2)){
                ReportUrl reportUrlInst2 = new ReportUrl()

                def localeNameParam = params.get(localeName2)
                def localeNameTemp = com.marketshare.commons.i18n.Locale.findWhere(name : localeNameParam)

                if(localeNameTemp){

                    reportUrlInst2.localeId = localeNameTemp.id.toLong()
                    reportUrlInst2.localeName = localeNameTemp
                    reportUrlInst2.reportId = reportInst.id
                    reportUrlInst2.name =  params.get(name2)? params.get(name2) :"NA"
                    reportUrlInst2.description =  params.get(description2)? params.get(description2) :"NA"
                    reportUrlInst2.url =  reportInst.reportType == Constants.reportType ?(params.get(url2)? params.get(url2) : params.get(miniUrl2)):null
                    reportUrlInst2.miniUrl = params.get(miniUrl2)? params.get(miniUrl2) :"NA"
                    reportUrlInst2.height = reportInst.reportType==Constants.reportType ? null :(params.get(height2) ? params.get(height2).toInteger() :1000.toInteger())
                    reportUrlInst2.save(failOnError: true, flush:true)
                }
                else{
                    log.println("No Locale found for the entered locale name: " +localeNameTemp)
                }
            }
        }

        log.println("AdhocReportService.saveReport created record : " +params)

        log.println("AdhocReportService.saveReport exit : ")
        return true
    }

    def updateReport(def params){

        log.println("AdhocReportService.saveReport updating record : ")
        Report reportInst = Report.findWhere(id: params.id.toLong())
        reportInst.name = reportInst.name
        reportInst.code = ""
        reportInst.description = "NA"
        reportInst.tableauReportMiniURL  = ""//params.tableauReportMiniURL ?  params.tableauReportMiniURL  :"NA"
        reportInst.tableauReportURL  = ""//arams.tableauReportURL? params.tableauReportURL :"NA"
        reportInst.linkName = ""
        reportInst.level = null
        reportInst.reportOrderId = params.reportOrderId?params.reportOrderId.toInteger():""
        reportInst.showRelatedInsights = null
        reportInst.relatedInsightsOpen = null
        reportInst.isAdminOnly = params.isAdminOnly ? true : false
        reportInst.reportDirectory = ""
        if (params.reportType == Constants.reportType){
            reportInst.reportType = Constants.reportType
            reportInst.reportGroupId = null
        }
        else if (params.reportType == Constants.reportTypeTableau){
            reportInst.reportType = Constants.reportTypeTableau
            reportInst.reportGroupId = params.reportGroupId? params.reportGroupId.toLong() : null
        }else if (params.reportType == Constants.reportTypeArcadia){
            reportInst.reportType = Constants.reportTypeArcadia
            reportInst.reportGroupId = params.reportGroupId? params.reportGroupId.toLong() : null
        }
        /*reportInst.reportType = Constants.reportType*/
        reportInst.createdDate = new Date()
        //reportInst.reportGroup = null
        //reportInst.reportParams = null;
        reportInst.reportMetas = null;
        reportInst.save(failOnError: true, flush:true)


        //def reportUrlInst = ReportUrl.findAllWhere(reportId: reportInst.id)

        for(Integer i = 0 ; i<= (params.size() - 10.toInteger() ); i++){

            log.println(i)
            def localeName = "localeName"+i
            def url = "url"+i
            def miniUrl = "miniUrl"+i
            def name = "name"+i
            def description = "description"+i
            def height = "height"+i
            if(params.get(localeName)){
                def localeNameParam = params.get(localeName)
                def localeNameTemp = com.marketshare.commons.i18n.Locale.findWhere(name : localeNameParam)
                ReportUrl newReportUrl = ReportUrl.findWhere(reportId:  reportInst.id , localeId: localeNameTemp?.id.toLong())
                if(localeNameTemp){
                    if(newReportUrl == null){
                        newReportUrl = new ReportUrl()
                        newReportUrl.localeId = localeNameTemp.id.toLong()
                        newReportUrl.localeName = localeNameTemp
                        newReportUrl.reportId = reportInst.id
                        newReportUrl.url =  reportInst.reportType == Constants.reportType ?(params.get(url)? params.get(url) :params.get(miniUrl)):null
                        newReportUrl.miniUrl = params.get(miniUrl)? params.get(miniUrl) :"NA"
                        newReportUrl.name = params.get(name)? params.get(name) :"NA"
                        newReportUrl.description = params.get(description)? params.get(description) :"NA"
                        newReportUrl.height = reportInst.reportType==Constants.reportType ? null : (params.get(height) ? params.get(height).toInteger() :1000.toInteger())
                        newReportUrl.save(failOnError: true, flush:true)
                    }else
                    {
                        newReportUrl.localeId = localeNameTemp.id.toLong()
                        newReportUrl.localeName = localeNameTemp
                        newReportUrl.reportId = reportInst.id
                        newReportUrl.url =  reportInst.reportType == Constants.reportType ?(params.get(url)? params.get(url) :params.get(miniUrl)):null
                        newReportUrl.miniUrl = params.get(miniUrl)? params.get(miniUrl) :"NA"
                        newReportUrl.name = params.get(name)? params.get(name) :"NA"
                        newReportUrl.description = params.get(description)? params.get(description) :"NA"
                        newReportUrl.height = reportInst.reportType==Constants.reportType ? null : (params.get(height) ? params.get(height).toInteger() :1000.toInteger())
                        newReportUrl.save(failOnError: true, flush:true)
                    }

                    if(newReportUrl.localeName == "en"){
                        reportInst.name = newReportUrl.name;
                        reportInst.save(failOnError: true, flush:true)
                    }else if(!ReportUrl.findWhere(reportId: reportInst.id.toLong(),localeName: "en")){
                        reportInst.name = newReportUrl.name;
                        reportInst.save(failOnError: true, flush:true)
                    }
                }
                else{
                    log.println("No Locale found for the entered locale name: " +localeNameTemp)
                }
            }
        }

        log.println("AdhocReportService.saveReport updated record : ")

        log.println("AdhocReportService.saveReport exit : ")
        return true
    }

    def saveReportConfig(def params, Long clientId){
        /*def reportSummary= ReportSummaryConf.findWhere(clientId:clientId)
        if(reportSummary){
            reportSummary.spendLabel=params.spendLabel
        }
        else{

            ReportSummaryConf reportSummaryNew= new ReportSummaryConf()
            reportSummaryNew.clientId=clientId
            reportSummaryNew.spendLabel= params.spendLabel
            reportSummaryNew.save(failOnError: true, flush:true)

        }*/

        for(Integer i = 0 ; i < ((params.size() - 3) /2); i++){
            def localeName = "localeName" + i
            def spendLabel  = "spendLabel" + i
            println "localeName" + localeName
            println "spendLabel" + spendLabel

            def reportSummaryConfTemp = ReportSummaryConf.findWhere(localeId:  params.get(localeName).toLong())
            if (reportSummaryConfTemp ){
                reportSummaryConfTemp.spendLabel = params.get(spendLabel)
            }else{
                ReportSummaryConf reportSummaryConfInst = new ReportSummaryConf()
                reportSummaryConfInst.spendLabel = params.get(spendLabel)
                //reportSummaryConfInst.localeName = (com.marketshare.commons.i18n.Locale.findWhere(name : params.get(localeName).toLong())).name.toString()
                reportSummaryConfInst.localeId =  params.get(localeName).toLong()
                reportSummaryConfInst.save(flush: true,failOnError: true)
            }
        }

    }


    public String getSpendLabel(Long clientId){
        String label = null
        User userInstance = userService.getCurrentSessionUser()
        Locale userLocale =  userInstance.locale
        def reportSummary= ReportSummaryConf.findWhere(clientId:clientId, localeId: userLocale.id.toLong()  )
        if((reportSummary && reportSummary.spendLabel) && reportSummary.spendLabel!= " "){
            label = reportSummary.spendLabel
        }
        else label = Constants.DASHBOARD_DEF_LABEL

        return label
    }


}
