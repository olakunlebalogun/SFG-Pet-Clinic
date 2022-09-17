package com.olakunle.sfgpetclinic.models;

import jdk.jfr.Enabled;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Speciality extends  BaseEntity{
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
