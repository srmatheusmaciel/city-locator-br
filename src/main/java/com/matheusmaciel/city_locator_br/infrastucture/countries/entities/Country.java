package com.matheusmaciel.city_locator_br.infrastucture.countries.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pais")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "nome_pt")
    private String portugueseName;

    @Column(name = "sigla")
    private String code;

    private Integer bacen;

}
