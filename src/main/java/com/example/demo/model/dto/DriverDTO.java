package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DriverDTO {

    Integer age;
    String firstName;
    String lastName;
    List<CarDTO> cars;
}
