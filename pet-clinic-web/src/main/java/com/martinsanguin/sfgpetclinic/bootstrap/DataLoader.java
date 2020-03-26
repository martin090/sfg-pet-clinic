package com.martinsanguin.sfgpetclinic.bootstrap;

import com.martinsanguin.sfgpetclinic.model.*;
import com.martinsanguin.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = this.petTypeService.findAll().size();
        if(count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        Visit dogVisit = new Visit();
        dogVisit.setDescription("Martin comes with Amelie");
        dogVisit.setDate(LocalDate.now());
        dogVisit.setPet(martinsPet);

        ownerService.save(martin);

        visitService.save(dogVisit);

        System.out.println("Owners loaded..");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialityService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialityService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialityService.save(dentistry);

        Vet vet = new Vet();
        vet.setFirstName("Flor");
        vet.setLastName("Malerba");
        vet.getSpecialities().add(savedRadiology);

        vetService.save(vet);

        System.out.println("Vets loaded..");
    }
}
