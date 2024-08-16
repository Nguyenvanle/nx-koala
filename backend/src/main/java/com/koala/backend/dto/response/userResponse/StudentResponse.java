package com.koala.backend.dto.response.userResponse;

import com.koala.backend.dto.response.mediaResponse.ImageResponse;
import com.koala.backend.entity.media.Image;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
  String userId;
  String username;
//  String password;
  String firstName;
  String lastName;
  LocalDate userBirth;
  String email;
  String role;
  Image image;
}
