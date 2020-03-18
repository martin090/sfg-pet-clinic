package com.martinsanguin.sfgpetclinic.bootstrap;

import com.martinsanguin.sfgpetclinic.model.Owner;
import com.martinsanguin.sfgpetclinic.model.Vet;
import com.martinsanguin.sfgpetclinic.services.OwnerService;
import com.martinsanguin.sfgpetclinic.services.VetService;
import com.martinsanguin.sfgpetclinic.services.map.OwnerServiceMap;
import com.martinsanguin.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("Martin");
        owner.setLastName("Sanguin");

        ownerService.save(owner);

        System.out.println("Owners loaded..");

        Vet vet = new Vet();
        vet.setFirstName("Flor");
        vet.setLastName("Malerba");

        vetService.save(vet);

        System.out.println("Vets loaded..");

    }
}
