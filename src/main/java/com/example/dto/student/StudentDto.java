package com.example.dto.student;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class StudentDto {

    Long id;
    String name;
    String surname;
    String  address;
    String  phoneNumber;

}
