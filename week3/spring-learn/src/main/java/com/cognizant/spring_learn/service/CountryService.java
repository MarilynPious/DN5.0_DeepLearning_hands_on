package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.bean.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    ApplicationContext context =
            new ClassPathXmlApplicationContext("country.xml");

    public Country getCountry(String code) {

        switch (code.toUpperCase()) {

            case "IN":
                return context.getBean("india", Country.class);

            case "US":
                return context.getBean("usa", Country.class);

            case "JP":
                return context.getBean("japan", Country.class);

            default:
                return null;
        }
    }
}