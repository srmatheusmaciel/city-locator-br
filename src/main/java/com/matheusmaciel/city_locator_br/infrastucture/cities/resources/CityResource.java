package com.matheusmaciel.city_locator_br.infrastucture.cities.resources;

import com.matheusmaciel.city_locator_br.infrastucture.cities.entities.City;
import com.matheusmaciel.city_locator_br.infrastucture.cities.repositories.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource {

    private final CityRepository cityRepository;

    public CityResource(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public Page<City> cities(final Pageable page) {
        return cityRepository.findAll(page);
    }

    @GetMapping("/{name}")
    public ResponseEntity getCityByName(@PathVariable String name) {
        Optional<City> city = cityRepository.findByName(name);

        if (city.isPresent()) return ResponseEntity.ok().body(city.get());
        else return ResponseEntity.notFound().build();

    }


    }

