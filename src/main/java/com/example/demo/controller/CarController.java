package com.example.demo.controller;

import com.example.demo.service.CarService;
import com.example.demo.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final DriverService driverService;
}
