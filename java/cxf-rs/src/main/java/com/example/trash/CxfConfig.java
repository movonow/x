package com.example.trash;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.MultipartProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class CxfConfig {

//    @Bean
//    public SpringComponentScanServer jaxrsServer(FileUploadService fileUploadService) {
//        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
//        factoryBean.setServiceBean(fileUploadService);
//        factoryBean.setAddress("/api");
//        return new SpringComponentScanServer();
//    }

//    @Bean
//    public JAXRSServerFactoryBean jaxrsServer(FileUploadService fileUploadService) {
//        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
//        factoryBean.setServiceBean(fileUploadService);
//        factoryBean.setAddress("/api");
//
//        // Enable multipart provider
//        factoryBean.setProviders(Collections.singletonList(new MultipartProvider()));
//        return factoryBean;
//    }
}
