def metaDataList= [0,0,1,null,5,6,9,5]
def segmentLevel=[0]
def phaseLevel=[0,null]
def productLevel=[0,1,3,4,5]
def geoLevel=[0,1,3]
def channelLevel=[0]
def prodXSectLvlList = new HashSet()
def chnlXSectLvlList = new HashSet()
def phaseXSectLvlList = new HashSet()
def sgmntXSectLvlList = new HashSet()
def geoXSectLvlList = new HashSet()
metaDataList.each {
    sgmntXSectLvlList.add(segmentLevel)
    phaseXSectLvlList.add(phaseLevel)
    prodXSectLvlList.add(productLevel)
    geoXSectLvlList.add(geoLevel)
    chnlXSectLvlList.add(channelLevel)
}
def sgmntSize = sgmntXSectLvlList.size()
def prodSize = prodXSectLvlList.size()
def chnlSize = chnlXSectLvlList.size()
def geoSize = geoXSectLvlList.size()
def phaseSize = phaseXSectLvlList.size()

if(sgmntSize in (1..3)) {
    if(sgmntXSectLvlList.contains(null)){ println "ERROR IN SEGMENT LEVEL"}
    if(sgmntSize==1){}
    else if(sgmntSize==2 && (sgmntXSectLvlList.contains(0)||sgmntXSectLvlList.contains(1))){}
    else if(sgmntSize==3 && sgmntXSectLvlList.containsAll(0,1)){}
    else { println "ERROR IN SEGMENT LEVEL"}
}else { println "ERROR IN SEGMENT LEVEL"}
if(prodSize in (1..3)) {
    if(prodXSectLvlList.contains(null)){ println "ERROR IN PRODUCT LEVEL"}
    if(prodSize==1){}
    else if(prodSize==2 && (prodXSectLvlList.contains(0)||prodXSectLvlList.contains(1))){}
    else if(prodSize==3 && prodXSectLvlList.containsAll(0,1)){}
    else { println "ERROR IN PRODUCT LEVEL"}
}else { println "ERROR IN PRODUCT LEVEL"}
if(geoSize in (1..3)) {
    if(geoXSectLvlList.contains(null)){ println "ERROR IN GEO LEVEL"}
    if(geoSize==1){}
    else if(geoSize==2 && (geoXSectLvlList.contains(0)||geoXSectLvlList.contains(1))){}
    else if(geoSize==3 && geoXSectLvlList.containsAll(0,1)){}
    else { println "ERROR IN GEO LEVEL"}
}else{ println "ERROR IN GEO LEVEL"}
if(phaseSize in (1..3)) {
    if(phaseXSectLvlList.contains(null)){ println "ERROR IN PHASE LEVEL"}
    if(phaseSize==1){}
    else if(phaseSize==2 && (phaseXSectLvlList.contains(0)||phaseXSectLvlList.contains(1))){}
    else if(phaseSize==3 && phaseXSectLvlList.containsAll(0,1)){}
    else { println "ERROR IN PHASELEVEL"}
}else { println "ERROR IN PHASE LEVEL"}
if(chnlSize in (1..3)) {
    if(chnlXSectLvlList.contains(null)){ println "ERROR IN CHANNEL LEVEL"}
    if(chnlSize==1){}
    else if(chnlSize==2 && (chnlXSectLvlList.contains(0)||chnlXSectLvlList.contains(1))){}
    else if(chnlSize==3 && chnlXSectLvlList.containsAll(0,1)){}
    else { println "ERROR IN CHANNEL LEVEL"}
} else{ println "ERROR IN CHANNEL LEVEL"}