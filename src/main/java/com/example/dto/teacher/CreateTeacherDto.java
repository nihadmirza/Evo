package com.example.dto.teacher;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CreateTeacherDto {
     String name;
     String surname;
     Integer lessonCount;

}
