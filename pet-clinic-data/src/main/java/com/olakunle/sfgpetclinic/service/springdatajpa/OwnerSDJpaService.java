package com.olakunle.sfgpetclinic.service.springdatajpa;

import com.olakunle.sfgpetclinic.models.Owner;
import com.olakunle.sfgpetclinic.repositories.OwnerRepository;
import com.olakunle.sfgpetclinic.repositories.PetRepository;
import com.olakunle.sfgpetclinic.repositories.PetTypeRepository;
import com.olakunle.sfgpetclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;



    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);

            return optionalOwner.orElse(null);

    }

    @Override
    public Owner save(Owner obj) {
        return ownerRepository.save(obj);
    }

    @Override
    public void delete(Owner obj) {
        ownerRepository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String name) {
        return ownerRepository.findByLastName(name);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastname) {

        return ownerRepository.findAllByLastNameLike(lastname);
    }
}
