package com.matheusmaciel.city_locator_br.infrastucture.staties.resources;

import com.matheusmaciel.city_locator_br.infrastucture.staties.entities.State;
import com.matheusmaciel.city_locator_br.infrastucture.staties.repositories.StateRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staties")
public class StateResource {

    private final StateRepository stateRepository;

    public StateResource(final StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    public List<State> staties() {
        return stateRepository.findAll();
    }



}
