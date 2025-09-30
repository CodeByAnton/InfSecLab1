package com.annton.lab1.controllers;

import com.annton.lab1.dto.CarRequestDTO;
import com.annton.lab1.entities.Car;
import com.annton.lab1.entities.User;
import com.annton.lab1.services.CarService;
import com.annton.lab1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class DataController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<?> addCar(@RequestBody CarRequestDTO carRequestDTO) {
        Car car=carService.addCar(carRequestDTO.model(), carRequestDTO.power(), carRequestDTO.price());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(String.format("Car %s append",car.getModel()));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars=carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

}
