package com.example.demo.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "drivers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "age")
    Integer age;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    LocalDate createdAt;
    @Column(name = "updated_at")
    LocalDate updatedAt;

    @OneToMany(cascade = CascadeType.ALL)
    List<Car> cars;


}

