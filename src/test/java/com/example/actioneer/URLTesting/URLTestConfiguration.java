package com.example.actioneer.URLTesting;


import com.example.actioneer.service.scraper.PriceService;
import com.example.actioneer.service.scraper.UrlService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class URLTestConfiguration {
    @Bean
    @Primary
    public PriceService priceService(){
        return Mockito.mock(PriceService.class);
    }
}
