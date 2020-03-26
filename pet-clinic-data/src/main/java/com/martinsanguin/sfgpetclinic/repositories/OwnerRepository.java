package com.martinsanguin.sfgpetclinic.repositories;

import com.martinsanguin.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
