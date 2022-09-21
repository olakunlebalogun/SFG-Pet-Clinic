package com.olakunle.sfgpetclinic.service.springdatajpa;

import com.olakunle.sfgpetclinic.models.Owner;
import com.olakunle.sfgpetclinic.repositories.OwnerRepository;
import com.olakunle.sfgpetclinic.repositories.PetRepository;
import com.olakunle.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Alonso";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    Owner returnedOwners;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        returnedOwners = Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        returnedOwnerSet.add(Owner.builder().id(1L).build());
        returnedOwnerSet.add(Owner.builder().id(2L).city("LA").build());


        when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);
        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwners));
        Owner owner = service.findById(1L);
        assertEquals(1L, owner.getId());
        assertNotNull(owner);
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(1L);
//        assertEquals(1L, owner.getId());
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnedOwners);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }


    @Test
    void delete() {
        service.delete(returnedOwners);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        Owner ownerAlonso = Owner.builder().id(1l).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(ownerAlonso);
        Owner olakunle = service.findByLastName("Olakunle");
        
        assertEquals(LAST_NAME, olakunle.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}