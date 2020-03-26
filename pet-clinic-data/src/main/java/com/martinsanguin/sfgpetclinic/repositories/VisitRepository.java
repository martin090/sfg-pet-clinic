package com.martinsanguin.sfgpetclinic.repositories;

import com.martinsanguin.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
