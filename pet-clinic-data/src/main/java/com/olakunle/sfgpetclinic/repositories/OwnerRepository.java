package com.olakunle.sfgpetclinic.repositories;

import com.olakunle.sfgpetclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);
}
