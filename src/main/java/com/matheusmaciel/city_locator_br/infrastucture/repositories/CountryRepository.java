package com.matheusmaciel.city_locator_br.infrastucture.repositories;

import com.matheusmaciel.city_locator_br.infrastucture.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByCode(String code);
}
