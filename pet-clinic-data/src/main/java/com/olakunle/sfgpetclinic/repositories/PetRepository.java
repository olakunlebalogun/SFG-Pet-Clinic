package com.olakunle.sfgpetclinic.repositories;

import com.olakunle.sfgpetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
