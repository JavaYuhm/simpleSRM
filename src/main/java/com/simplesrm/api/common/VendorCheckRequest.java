package com.simplesrm.api.common;

import java.util.List;

public class VendorCheckRequest {
    private List<Business> businesses;

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
}

