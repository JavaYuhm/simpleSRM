package com.simplesrm.api.common;

public class VendorData {
    private String bno;
    private String valid;
    private VendorRequestParam requestParam;
    private VendorStatus status;

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public VendorRequestParam getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(VendorRequestParam requestParam) {
        this.requestParam = requestParam;
    }

    public VendorStatus getStatus() {
        return status;
    }

    public void setStatus(VendorStatus status) {
        this.status = status;
    }
}