package com.koala.backend.entity;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private Date dob;
}
