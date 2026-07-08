package com.cognizant.orm_learn.controller;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }

    @GetMapping("/country")
    public Country getCountryByName(@RequestParam String name) {
        return countryService.getCountryByName(name);
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }
    @GetMapping("/country/jpql")
    public Country getCountryJPQL(@RequestParam String name) {
        return countryService.getCountryUsingJPQL(name);
    }
    @GetMapping("/country/native")
    public Country getCountryNative(@RequestParam String name) {
        return countryService.getCountryNative(name);
    }
    @PutMapping("/countries/{code}")
    public Country updateCountry(@PathVariable String code,
                                 @RequestBody Country country) {

        return countryService.updateCountry(code, country);
    }
    @DeleteMapping("/countries/{code}")
    public String deleteCountry(@PathVariable String code) {

        countryService.deleteCountry(code);

        return "Country deleted successfully.";
    }
}