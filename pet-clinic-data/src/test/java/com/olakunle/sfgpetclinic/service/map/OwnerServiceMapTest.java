package com.olakunle.sfgpetclinic.service.map;

import com.olakunle.sfgpetclinic.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {


    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String lastname = "Olakunle";
    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastname).build());

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner saveOwner = ownerServiceMap.save(owner2);
        assertEquals(id, saveOwner.getId());
    }
    @Test
    void saveWithNoId() {
        Owner noIdOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(noIdOwner);
//        assertNotNull(noIdOwner.getId());  // Generate Id if the owner does not supply one needs to be implemented here.
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner lastNameOwner = ownerServiceMap.findByLastName(lastname);
        assertNotNull(lastNameOwner);
        assertEquals(ownerId, lastNameOwner.getId());

        /**
         * <p>
         *     the commented test below is my own assertion
         *
         * </p>
         * @author Olakunle Balogun
         */
//        assertEquals(lastname, lastNameOwner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner lastNameOwner = ownerServiceMap.findByLastName("foo");
        assertNull(lastNameOwner);

    }

}