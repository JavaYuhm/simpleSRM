package com.simplesrm;

import com.simplesrm.config.properties.AppProperties;
import com.simplesrm.config.properties.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        CorsProperties.class,
        AppProperties.class
})
public class SimpleSrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSrmApplication.class, args);
    }

}
