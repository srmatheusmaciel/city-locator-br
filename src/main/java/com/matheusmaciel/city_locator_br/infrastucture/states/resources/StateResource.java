package com.matheusmaciel.city_locator_br.infrastucture.states.resources;

import com.matheusmaciel.city_locator_br.infrastucture.states.entities.State;
import com.matheusmaciel.city_locator_br.infrastucture.states.repositories.StateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource {

    private final StateRepository stateRepository;

    public StateResource(final StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public List<State> states() {
        return stateRepository.findAll();
    }



}
