package com.matheusmaciel.city_locator_br.infrastucture.resources;

import com.matheusmaciel.city_locator_br.infrastucture.entities.Country;
import com.matheusmaciel.city_locator_br.infrastucture.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Page<Country> countries(Pageable page){
        return countryRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCountryById(@PathVariable Long id) {
        Optional<Country> country = countryRepository.findById(id);

        if(country.isPresent()){
            return ResponseEntity.ok().body(country.get());
        } else{
            return ResponseEntity.notFound().build();
        }

    }



}
