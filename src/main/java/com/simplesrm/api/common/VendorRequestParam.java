package com.simplesrm.api.common;

public class VendorRequestParam {
    private String bNo;
    private String startDt;
    private String pNm;
    private String pNm2;
    private String bNm;
    private String corpNo;
    private String bType;
    private String bSector;

    public String getBNo() {
        return bNo;
    }

    public void setBNo(String bNo) {
        this.bNo = bNo;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getPNm() {
        return pNm;
    }

    public void setPNm(String pNm) {
        this.pNm = pNm;
    }

    public String getPNm2() {
        return pNm2;
    }

    public void setPNm2(String pNm2) {
        this.pNm2 = pNm2;
    }

    public String getBNm() {
        return bNm;
    }

    public void setBNm(String bNm) {
        this.bNm = bNm;
    }

    public String getCorpNo() {
        return corpNo;
    }

    public void setCorpNo(String corpNo) {
        this.corpNo = corpNo;
    }

    public String getBType() {
        return bType;
    }

    public void setBType(String bType) {
        this.bType = bType;
    }

    public String getBSector() {
        return bSector;
    }

    public void setBSector(String bSector) {
        this.bSector = bSector;
    }
}