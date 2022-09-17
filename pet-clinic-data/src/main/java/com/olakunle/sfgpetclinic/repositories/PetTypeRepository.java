package com.olakunle.sfgpetclinic.repositories;

import com.olakunle.sfgpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
