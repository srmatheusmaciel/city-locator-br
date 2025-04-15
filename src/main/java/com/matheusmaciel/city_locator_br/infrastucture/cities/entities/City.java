package com.matheusmaciel.city_locator_br.infrastucture.cities.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;


@Entity
@Table(name = "cidade")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private Integer uf;

    private Integer ibge;

    // 1st
    @Column(name = "lat_lon")
    private String geolocation;

    // 2nd
    @Convert(converter = PointConverter.class)
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;


}