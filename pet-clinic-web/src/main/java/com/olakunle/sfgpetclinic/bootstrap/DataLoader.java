package com.olakunle.sfgpetclinic.bootstrap;

import com.olakunle.sfgpetclinic.models.Owner;
import com.olakunle.sfgpetclinic.models.Vet;
import com.olakunle.sfgpetclinic.service.OwnerService;
import com.olakunle.sfgpetclinic.service.VetService;
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

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Amelia");
        owner1.setLastName("Greiser");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Corry");
        owner2.setLastName("MacRonald");
        ownerService.save(owner2);

        System.out.println("saving sets of owners");

        // save two sets of vets
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Nate");
        vet1.setLastName("Sautter");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jennifer");
        vet2.setLastName("Flynn");
        vetService.save(vet2);
        System.out.println("saving sets of vets");
    }
}
