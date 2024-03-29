package com.olakunle.sfgpetclinic.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
@Table(name = "vets")
public class Vet extends Person{
    @ManyToMany(fetch = FetchType.EAGER)@JoinTable(name = "vet_speciality", joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> speciality = new HashSet<>();

    public Vet(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

}
