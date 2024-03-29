package com.olakunle.sfgpetclinic.service;

import com.olakunle.sfgpetclinic.models.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String name);

    List<Owner> findAllByLastNameLike (String lastname);

}

