package com.martinsanguin.sfgpetclinic.bootstrap;

import com.martinsanguin.sfgpetclinic.model.Owner;
import com.martinsanguin.sfgpetclinic.model.Pet;
import com.martinsanguin.sfgpetclinic.model.PetType;
import com.martinsanguin.sfgpetclinic.model.Vet;
import com.martinsanguin.sfgpetclinic.services.OwnerService;
import com.martinsanguin.sfgpetclinic.services.PetTypeService;
import com.martinsanguin.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        System.out.println("dot pet type id: " + dog.getId());

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("cat pet type id: " + cat.getId());

        Owner martin = new Owner();
        martin.setFirstName("Martin");
        martin.setLastName("Sanguin");
        martin.setAddress("Test 123");
        martin.setCity("Buenos Aires");
        martin.setTelephone("1231232");

        Pet martinsPet = new Pet();
        martinsPet.setPetType(savedDogPetType);
        martinsPet.setOwner(martin);
        martinsPet.setName("Amelie");
        martinsPet.setBirthday(LocalDate.now());
        martin.getPets().add(martinsPet);

        ownerService.save(martin);

        System.out.println("Owners loaded..");

        Vet vet = new Vet();
        vet.setFirstName("Flor");
        vet.setLastName("Malerba");

        vetService.save(vet);

        System.out.println("Vets loaded..");

    }
}
