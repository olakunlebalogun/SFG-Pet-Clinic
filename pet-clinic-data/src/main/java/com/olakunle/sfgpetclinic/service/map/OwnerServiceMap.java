package com.olakunle.sfgpetclinic.service.map;

import com.olakunle.sfgpetclinic.models.Owner;
import com.olakunle.sfgpetclinic.models.Pet;
import com.olakunle.sfgpetclinic.service.OwnerService;
import com.olakunle.sfgpetclinic.service.PetService;
import com.olakunle.sfgpetclinic.service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
@RequiredArgsConstructor
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;



    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner obj) {
        super.delete(obj);
    }

    @Override
    public Owner save(Owner obj) {
        if (obj != null) {
            if (obj.getPets() != null) {
                obj.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }


                    }
                    else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });

            }
            return super.save(obj);
        }
        else {
            return null;
        }
//        return super.save( obj);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String name) {

        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastname) {
        // TODO: Implement later
        return null;
    }


}
