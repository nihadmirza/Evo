package com.example.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, name ="name")
    String name;

    @Column(nullable = false, name ="surname")
    String surname;

    @Column(nullable = false, name ="address")
    String  address;

    @Column(nullable = false, name ="phone_number")
    String  phoneNumber;

}
