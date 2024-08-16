package com.koala.backend.repository.userRepository;

import com.koala.backend.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
  boolean existsByUsername(String username);
}
