package com.olakunle.sfgpetclinic.bootstrap;

import com.olakunle.sfgpetclinic.models.*;
import com.olakunle.sfgpetclinic.service.*;
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

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Amelia");
        owner1.setLastName("Greiser");
        owner1.setCity("Florida");
        owner1.setAddress("23 townborough street");
        owner1.setTelephone("09034343232");

        Pet ameliaDog = new Pet();
        ameliaDog.setPetType(saveDogPetType);
        ameliaDog.setOwner(owner1);
        ameliaDog.setBirthdate(LocalDate.now());
        ameliaDog.setName("Bingo");

        owner1.getPets().add(ameliaDog);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstName("Corry");
        owner2.setLastName("MacRonald");
        owner2.setTelephone("08023212199");
        owner2.setCity("Venice");
        owner2.setAddress("77 Saint MacAnthony");

        Pet corryCat = new Pet();
        corryCat.setName("musu");
        corryCat.setOwner(owner2);
        corryCat.setPetType(saveCatPetType);
        corryCat.setBirthdate(LocalDate.now());

        owner2.getPets().add(corryCat);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(corryCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Just checking in on some kuicty cat");

        visitService.save(catVisit);

        System.out.println("saving sets of owners");

        // save two sets of vets
        Vet vet1 = new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Nate");
        vet1.setLastName("Sautter");
        vet1.getSpeciality().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Jennifer");
        vet2.setLastName("Flynn");
        vet2.getSpeciality().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Saving sets of vets");
    }
}
