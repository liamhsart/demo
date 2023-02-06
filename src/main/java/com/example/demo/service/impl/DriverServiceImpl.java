package com.example.demo.service.impl;

import com.example.demo.model.dto.CarDTO;
import com.example.demo.model.dto.DriverDTO;
import com.example.demo.model.entity.Car;
import com.example.demo.model.entity.Driver;
import com.example.demo.model.repository.DriverRepository;
import com.example.demo.service.DriverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final ObjectMapper objectMapper;

    @Override
    public DriverDTO createDriver(DriverDTO driverDTO) {

        Driver driver = objectMapper.convertValue(driverDTO, Driver.class);
        List<Car> cars = driverDTO.getCars().stream()
                .map(c -> {
                    Car car = new Car();
                    car.setYear(c.getYear());
                    car.setColor(c.getColor());
                    return car;
                })
                .collect(Collectors.toList());

        driver.setCars(cars);
        Driver entity = driverRepository.save(driver);
        DriverDTO result = objectMapper.convertValue(entity, DriverDTO.class);
        List<CarDTO> carsDTO = entity.getCars().stream()
                .map(c -> {
                    CarDTO carDTO = new CarDTO();
                    carDTO.setYear(c.getYear());
                    carDTO.setColor(c.getColor());
                    return carDTO;
                })
                .collect(Collectors.toList());
        result.setCars(carsDTO);
        return result;
    }
}
