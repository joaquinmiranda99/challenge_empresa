package com.src.demo.application.service.carrera;

import com.src.demo.application.repository.carrera.CarreraRepository;
import com.src.demo.domain.model.Career;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {
    private final CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public List<Career> getAll() {
        return carreraRepository.findAll();
    }

    public Career getById(Long id) {
        return carreraRepository.getReferenceById(id);
    }

    public Career create(Career career) {
        return carreraRepository.save(career);
    }

    public Career update(Career career) {
        return carreraRepository.save(career);
    }

    public void delete(Long id) {
        carreraRepository.deleteById(id);
    }
}
