package com.martinsanguin.sfgpetclinic.bootstrap;

import com.martinsanguin.sfgpetclinic.model.Owner;
import com.martinsanguin.sfgpetclinic.model.PetType;
import com.martinsanguin.sfgpetclinic.model.Vet;
import com.martinsanguin.sfgpetclinic.services.OwnerService;
import com.martinsanguin.sfgpetclinic.services.PetTypeService;
import com.martinsanguin.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

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
