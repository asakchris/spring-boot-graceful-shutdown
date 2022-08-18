package org.example.graceful.controller;

import static org.example.graceful.util.Utils.run;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graceful.entity.User;
import org.example.graceful.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;

  @GetMapping(path = "/hello")
  @ResponseStatus(code = HttpStatus.OK)
  public Map<String, String> hello() {
    log.info("Enter hello");
    run(1);
    return Map.of("message", "Hello!");
  }

  @GetMapping(path = "/users")
  @ResponseStatus(code = HttpStatus.OK)
  public List<User> getAllUsers() {
    log.info("Enter getAllUsers");
    run(1);
    return userService.findAll();
  }
}
