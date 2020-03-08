package com.martinsanguin.sfgpetclinic.services;

import com.martinsanguin.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Pet id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
