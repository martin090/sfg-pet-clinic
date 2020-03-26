package com.martinsanguin.sfgpetclinic.repositories;

import com.martinsanguin.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
