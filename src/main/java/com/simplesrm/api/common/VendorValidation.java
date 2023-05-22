package com.simplesrm.api.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VendorValidation {
    String b_no;
    String start_dt;
    String p_nm;
    String p_nm2;
    String b_nm;
    String corp_no;
    String b_sector;
    String b_type;
}
