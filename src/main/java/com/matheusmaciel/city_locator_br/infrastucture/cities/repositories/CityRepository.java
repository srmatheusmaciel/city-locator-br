package com.matheusmaciel.city_locator_br.infrastucture.cities.repositories;

import com.matheusmaciel.city_locator_br.infrastucture.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {


    Optional<City> findByName(String name);

    @Query(value = "SELECT\n" +
            "        (lat_lon1::point <@> lat_lon2::point) AS distance\n" +
            "FROM (\n" +
            "        SELECT\n" +
            "    (SELECT lat_lon FROM cidade WHERE id = ?1) AS lat_lon1,\n" +
            "    (SELECT lat_lon FROM cidade WHERE id = ?2) AS lat_lon2\n" +
            ") AS sub;", nativeQuery = true)
    Double distanceByPoints(final Long cityId1, final Long cityId2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);
}


