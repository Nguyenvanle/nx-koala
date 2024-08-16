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
public class StudentCreateRequest {
  String username;
  String password;
  String firstName;
  String lastName;
  LocalDate userBirth;
  @Email
  String email;
  String imageUrl;
}
