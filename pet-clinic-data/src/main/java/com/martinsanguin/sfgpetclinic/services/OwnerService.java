package com.martinsanguin.sfgpetclinic.services;

import com.martinsanguin.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
