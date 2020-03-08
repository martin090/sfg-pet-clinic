package com.martinsanguin.sfgpetclinic.services;

import com.martinsanguin.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VerService {
    Vet findById(Vet id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
