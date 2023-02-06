package com.example.demo.controller;

import com.example.demo.model.dto.DriverDTO;
import com.example.demo.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping
    public DriverDTO createDriver(@RequestBody DriverDTO driverDTO) {
        return driverService.createDriver(driverDTO);
    }
}
