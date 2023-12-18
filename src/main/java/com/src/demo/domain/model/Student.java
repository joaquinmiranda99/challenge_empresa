package com.src.demo.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Student {
    @Id
    private Long id;
    @ManyToMany(mappedBy = "students")
    private Set<Career> careers;
    private String name;
    private String email;
    private int phoneNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
