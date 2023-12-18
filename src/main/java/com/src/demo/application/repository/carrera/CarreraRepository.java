package com.src.demo.application.repository.carrera;

import com.src.demo.domain.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CarreraRepository extends JpaRepository<Career, Long> {
}
