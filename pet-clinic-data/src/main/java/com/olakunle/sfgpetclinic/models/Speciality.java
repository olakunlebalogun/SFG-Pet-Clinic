package com.olakunle.sfgpetclinic.models;

import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "specialties")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Speciality extends  BaseEntity{
    @Column(name = "description")
    private String description;


}
