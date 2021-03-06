package com.example.actioneer;

import com.example.actioneer.model.Item;
import com.example.actioneer.repository.ItemRepository;
import com.example.actioneer.service.email.EmailPlanner;
import com.example.actioneer.service.email.EmailService;
import com.example.actioneer.service.scraper.PriceService;
import com.example.actioneer.service.scraper.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
public class ActioneerApplication {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    EmailPlanner emailPlanner;

    @Autowired
    UrlService urlService;

    public static void main(String[] args) {
        SpringApplication.run(ActioneerApplication.class, args);
    }

    @Scheduled(cron = "5 * * * * *")
    public void sendEmails() {
        List<Item> a = itemRepository.findAll();
        System.out.println(a);
        List<Item> b = urlService.getOnSaleURLS(a);
        System.out.println(b);
        Map<String, List<String>> c = emailPlanner.createEmailMap(b);
        System.out.println(c);
        emailService.sendEmail(c);

//        emailService.sendEmail(
//                emailPlanner.createEmailMap(
//                        urlService.getOnSaleURLS(
//                                itemRepository.findDistinctByURL()
//                        )
//                )
//        );
    }


    @Bean
    public CommandLineRunner init() {
        return args -> {
            Item item = Item.builder()
                    .email("rretlev@gmail.com")
                    .URL("one")
                    .domain("number")
                    .originalPrice(1.0)
                    .build();
            itemRepository.save(item);
            Item item2 = Item.builder()
                    .email("rretlev@gmail.com")
                    .URL("two")
                    .domain("number")
                    .originalPrice(1.0)
                    .build();
            itemRepository.save(item2);
            Item item3 = Item.builder()
                    .email("rretlev@gmail.com")
                    .URL("three")
                    .domain("number")
                    .originalPrice(1.0)
                    .build();
            itemRepository.save(item3);
            Item item4 = Item.builder()
                    .email("rretlev@gmail.com")
                    .URL("four")
                    .domain("number")
                    .originalPrice(1.0)
                    .build();
            itemRepository.save(item4);

        };
    }

}
