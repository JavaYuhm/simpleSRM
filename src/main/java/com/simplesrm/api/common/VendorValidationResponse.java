package com.simplesrm.api.common;

import java.util.List;

public class VendorValidationResponse {
    private int requestCnt;
    private int validCnt;
    private String statusCode;
    private List<VendorData> data;

    public int getRequestCnt() {
        return requestCnt;
    }

    public void setRequestCnt(int requestCnt) {
        this.requestCnt = requestCnt;
    }

    public int getValidCnt() {
        return validCnt;
    }

    public void setValidCnt(int validCnt) {
        this.validCnt = validCnt;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<VendorData> getData() {
        return data;
    }

    public void setData(List<VendorData> data) {
        this.data = data;
    }
}
