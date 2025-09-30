package com.annton.lab1.services;

import com.annton.lab1.entities.Car;
import com.annton.lab1.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car addCar(String model, Integer power, Integer price){
        Car car = new Car();
        car.setModel(HtmlUtils.htmlEscape(model));
        car.setPrice(price);
        car.setPower(power);

        return carRepository.save(car);
    }



    public List<Car> getAllCars(){
        return carRepository.findAll();
    }


}
