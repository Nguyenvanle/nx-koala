package com.koala.backend.entity.user;


import com.koala.backend.entity.media.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//create per entity have per table, connect with superclass through FK
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String userId;
  String username;
  String password;
  String firstName;
  String lastName;
  LocalDate userBirth;
  String email;
  String role;

  @OneToOne
  @JoinColumn(name = "image_url")
  Image image;
}
