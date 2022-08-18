package org.example.graceful.service;

import java.util.List;
import java.util.Optional;
import org.example.graceful.entity.User;

public interface UserService {
  Optional<User> findUser(String userName);

  List<User> findAll();
}
