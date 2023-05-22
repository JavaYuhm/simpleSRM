package com.simplesrm;

import com.simplesrm.config.properties.AppProperties;
import com.simplesrm.config.properties.CorsProperties;
import com.simplesrm.config.properties.VendorProperties;
import com.simplesrm.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableConfigurationProperties({
        CorsProperties.class,
        AppProperties.class,
        VendorProperties.class
})
public class SimpleSrmApplication {


    public static void main(String[] args) {
        SpringApplication.run(SimpleSrmApplication.class, args);
    }

}
