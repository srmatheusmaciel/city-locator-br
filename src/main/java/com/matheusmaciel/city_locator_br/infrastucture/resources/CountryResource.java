package com.matheusmaciel.city_locator_br.infrastucture.resources;

import com.matheusmaciel.city_locator_br.infrastucture.entities.Country;
import com.matheusmaciel.city_locator_br.infrastucture.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/code")
    public ResponseEntity<List<Country>> getCountriesByCode(@RequestParam String code) {
        var countries = countryRepository.findByCode(code);
        return ResponseEntity.ok().body(countries);
    }



}
