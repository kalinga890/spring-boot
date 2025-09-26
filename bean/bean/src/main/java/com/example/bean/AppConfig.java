package com.example.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean(name = "Phone pay")
    Payment payment(){
   Payment   p = new Payment();
   p.setProviderName("Phone pay");

   return p;
    }
    @Bean(value = "Google pay")
    Payment payment1(){
        Payment   p = new Payment();
        p.setProviderName("Google pay");

        return p;
    }

    @Bean
    String name(){

        return "Kalinga";
    }
    @Bean
    Integer integer(){
        return 30;
    }
}
