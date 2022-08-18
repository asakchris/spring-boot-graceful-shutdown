package org.example.graceful.repository;

import java.util.Optional;
import org.example.graceful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUserName(String userName);
}
