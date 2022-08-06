package com.olakunle.sfgpetclinic.service.map;

import com.olakunle.sfgpetclinic.models.Vet;
import com.olakunle.sfgpetclinic.service.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet obj) {
        super.delete(obj);
    }

    @Override
    public Vet save(Vet obj) {
        return super.save(obj.getId(), obj);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
