package com.olakunle.sfgpetclinic.service.map;

import com.olakunle.sfgpetclinic.models.Speciality;
import com.olakunle.sfgpetclinic.models.Vet;
import com.olakunle.sfgpetclinic.service.SpecialityService;
import com.olakunle.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if (obj.getSpeciality().size() > 0){
            obj.getSpeciality().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(obj);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
