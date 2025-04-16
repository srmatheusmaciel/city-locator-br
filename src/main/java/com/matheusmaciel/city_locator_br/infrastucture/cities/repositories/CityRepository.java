package com.matheusmaciel.city_locator_br.infrastucture.cities.repositories;

import com.matheusmaciel.city_locator_br.infrastucture.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {


    Optional<City> findByName(String name);
}
