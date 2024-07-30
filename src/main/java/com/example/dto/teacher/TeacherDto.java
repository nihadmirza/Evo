package com.example.dto.teacher;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class TeacherDto {
     Long id;
     String name;
     String surname;
     Integer lessonCount;

}
