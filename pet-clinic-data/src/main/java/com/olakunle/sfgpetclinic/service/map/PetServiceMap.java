package com.olakunle.sfgpetclinic.service.map;

import com.olakunle.sfgpetclinic.models.Pet;
import com.olakunle.sfgpetclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet obj) {
        super.delete(obj);
    }

    @Override
    public Pet save(Pet obj) {
        return super.save(obj);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
