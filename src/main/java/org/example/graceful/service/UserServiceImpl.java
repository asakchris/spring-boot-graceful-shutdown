package org.example.graceful.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graceful.entity.User;
import org.example.graceful.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  @Override
  @Transactional(readOnly = true)
  public Optional<User> findUser(String userName) {
    return repository.findByUserName(userName);
  }

  @Override
  @Transactional(readOnly = true)
  public List<User> findAll() {
    return repository.findAll();
  }
}
