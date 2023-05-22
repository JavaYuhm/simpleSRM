package com.simplesrm.api.controller.vendor;

import com.simplesrm.api.common.ApiResponse;
import com.simplesrm.api.service.vendor.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor
@RestController
public class VendorController {

    private final VendorService vendorService;


    @GetMapping(value = "/api/v1/checkVendor")
    public ApiResponse checkVendor(){

       String valid =  vendorService.VendorValidation();

       return ApiResponse.success("vendor", valid);

    }
}
