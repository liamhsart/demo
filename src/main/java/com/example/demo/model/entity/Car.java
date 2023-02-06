package com.example.demo.model.entity;

import com.example.demo.model.enums.Color;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cars")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "age")
    Integer year;

    @CreationTimestamp
    @Column(name = "created_at")
    LocalDate createdAt;
    @Column(name = "updated_at")
    LocalDate updatedAt;
    @Column(name = "color")
    Color color;
}
