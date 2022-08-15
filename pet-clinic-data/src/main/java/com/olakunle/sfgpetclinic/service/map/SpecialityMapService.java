package com.olakunle.sfgpetclinic.service.map;

import com.olakunle.sfgpetclinic.models.Speciality;
import com.olakunle.sfgpetclinic.service.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality obj) {
        super.delete(obj);
    }

    @Override
    public Speciality save(Speciality obj) {
        return super.save(obj);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
