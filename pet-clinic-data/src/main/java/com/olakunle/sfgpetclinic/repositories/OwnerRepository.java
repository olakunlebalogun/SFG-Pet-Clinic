package com.olakunle.sfgpetclinic.repositories;

import com.olakunle.sfgpetclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);

    List<Owner> findAllByLastNameLike (String lastname);

}
