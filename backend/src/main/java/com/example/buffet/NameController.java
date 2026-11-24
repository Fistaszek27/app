package com.example.buffet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    private final NameRepository repository;


    public NameController(NameRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/names")
    public Iterable<Name> getAllNames() {
        return repository.findAll();
    }

    

}