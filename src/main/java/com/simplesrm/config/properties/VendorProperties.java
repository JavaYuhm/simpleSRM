package com.simplesrm.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "vendor")
public class VendorProperties {
    private String vaildURL;
    private String serviceKey;
}