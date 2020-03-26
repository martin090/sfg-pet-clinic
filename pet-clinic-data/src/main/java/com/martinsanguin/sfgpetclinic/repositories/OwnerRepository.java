package com.martinsanguin.sfgpetclinic.repositories;

import com.martinsanguin.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findOwnerByLastName(String lastname);
}
