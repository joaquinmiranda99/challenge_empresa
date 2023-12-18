package com.src.demo.infra;

import com.src.demo.application.service.carrera.CarreraService;
import com.src.demo.domain.model.Career;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/carrera")
public class CarreraController {
    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
            this.carreraService = carreraService;
    }

    @GetMapping
    public ResponseEntity<List<Career>> getAllCarreras() {
        List<Career> careers = carreraService.getAll();
        return new ResponseEntity<>(careers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Career> getCarreraById(@PathVariable Long id) {
        Career career = carreraService.getById(id);
        return new ResponseEntity<>(career, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addCarrera(@RequestBody Career career) {
        carreraService.create(career);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateCarrera(
            @RequestBody Career career) {
        carreraService.update(career);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable Long id) {
        carreraService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}