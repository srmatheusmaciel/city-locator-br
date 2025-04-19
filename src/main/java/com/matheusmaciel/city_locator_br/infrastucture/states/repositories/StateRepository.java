package com.matheusmaciel.city_locator_br.infrastucture.states.repositories;

import com.matheusmaciel.city_locator_br.infrastucture.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
