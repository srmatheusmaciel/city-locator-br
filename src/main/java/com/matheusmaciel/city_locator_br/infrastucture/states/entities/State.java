package com.matheusmaciel.city_locator_br.infrastucture.states.entities;

import com.matheusmaciel.city_locator_br.infrastucture.countries.entities.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "estado")
@Getter
public class State {

    @Id
    private Long id;

    @Column(name= "nome")
    private String name;

    private String uf;

    private Integer ibge;

        // 1st
//      @Column(name = "pais")
//      private Integer countryId;

    // 2nd - @ManyToOne
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(JsonBinaryType.class)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    public State() {
    }

}
