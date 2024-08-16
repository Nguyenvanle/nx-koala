package com.koala.backend.dto.request.userRequest;

import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentUpdateRequest {
  String password;
  String firstName;
  String lastName;
  LocalDate userBirth;
  String imageUrl;
}
