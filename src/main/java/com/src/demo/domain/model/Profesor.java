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
public class Profesor {
    @Id
    private Long id;
    @ManyToMany(mappedBy = "profesors")
    private Set<Career> career;
    private String name;
    private String email;
    private int phoneNumber;
}
