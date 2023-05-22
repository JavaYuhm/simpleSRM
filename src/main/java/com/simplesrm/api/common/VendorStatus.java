package com.simplesrm.api.common;
public class VendorStatus {
    private String bNo;
    private String bStt;
    private String bSttCd;
    private String taxType;
    private String taxTypeCd;
    private String endDt;
    private String utccYn;
    private String taxTypeChangeDt;
    private String invoiceApplyDt;

    public String getBNo() {
        return bNo;
    }

    public void setBNo(String bNo) {
        this.bNo = bNo;
    }

    public String getBStt() {
        return bStt;
    }

    public void setBStt(String bStt) {
        this.bStt = bStt;
    }

    public String getBSttCd() {
        return bSttCd;
    }

    public void setBSttCd(String bSttCd) {
        this.bSttCd = bSttCd;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxTypeCd() {
        return taxTypeCd;
    }

    public void setTaxTypeCd(String taxTypeCd) {
        this.taxTypeCd = taxTypeCd;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public String getUtccYn() {
        return utccYn;
    }

    public void setUtccYn(String utccYn) {
        this.utccYn = utccYn;
    }

    public String getTaxTypeChangeDt() {
        return taxTypeChangeDt;
    }

    public void setTaxTypeChangeDt(String taxTypeChangeDt) {
        this.taxTypeChangeDt = taxTypeChangeDt;
    }

    public String getInvoiceApplyDt() {
        return invoiceApplyDt;
    }

    public void setInvoiceApplyDt(String invoiceApplyDt) {
        this.invoiceApplyDt = invoiceApplyDt;
    }
}