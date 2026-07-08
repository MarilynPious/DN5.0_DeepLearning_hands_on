package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }
    public Country getCountryUsingJPQL(String name) {
        return countryRepository.findCountryByName(name);
    }
    public Country getCountryNative(String name) {
        return countryRepository.findCountryNative(name);
    }
    public Country updateCountry(String code, Country country) {

        Country existingCountry = countryRepository.findById(code).orElse(null);

        if (existingCountry != null) {
            existingCountry.setName(country.getName());
            return countryRepository.save(existingCountry);
        }

        return null;
    }
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
}