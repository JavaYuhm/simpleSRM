package com.simplesrm.api.service.vendor;

import com.simplesrm.api.common.*;
import com.simplesrm.config.properties.VendorProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@Service
public class VendorService {

    private final VendorProperties vendorProperties;


    public String VendorValidation()  {

        // 얘를 DTO 변경해서 데이터를 받아와야 할 거 같습니다.
        VendorValidation vendorValidation = VendorValidation.builder()
                .b_no("1098177256")
                .start_dt("20020401")
                .p_nm("박상권")
                .p_nm2("")
                .b_nm("(주)그린테크놀로지")
                .corp_no("")
                .b_sector("")
                .b_type("")
                .build();

/*        String requestBody = "{\n" +
                "  \"businesses\": [\n" +
                "    {\n" +
                "      \"b_no\": \"" + vendorValidation.getB_no() + "\",\n" +
                "      \"start_dt\": \"" + vendorValidation.getStart_dt() + "\",\n" +
                "      \"p_nm\": \"" + vendorValidation.getP_nm() + "\",\n" +
                "      \"p_nm2\": \"" + vendorValidation.getP_nm2() + "\",\n" +
                "      \"b_nm\": \"" + vendorValidation.getB_nm() + "\",\n" +
                "      \"corp_no\": \"" + vendorValidation.getCorp_no() + "\",\n" +
                "      \"b_sector\": \"" + vendorValidation.getB_sector() + "\",\n" +
                "      \"b_type\": \"" + vendorValidation.getB_type() + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";*/

        VendorCheckRequest vendorCheckRequest = new VendorCheckRequest();
        Business business = new Business();
        business.setB_no(vendorValidation.getB_no());
        business.setStart_dt(vendorValidation.getStart_dt());
        business.setP_nm(vendorValidation.getP_nm());
        business.setP_nm2(vendorValidation.getP_nm2());
        business.setB_nm(vendorValidation.getB_nm());
        business.setCorp_no(vendorValidation.getCorp_no());
        business.setB_sector(vendorValidation.getB_sector());
        business.setB_type(vendorValidation.getB_type());
        vendorCheckRequest.setBusinesses(Collections.singletonList(business));

        WebClient webClient = WebClient.builder()
                .baseUrl(vendorProperties.getVaildURL() + vendorProperties.getServiceKey())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<String> responseMono = webClient.post()
                .bodyValue(vendorCheckRequest)
                .retrieve()
                .bodyToMono(String.class);

        return responseMono.block();
    }
}
