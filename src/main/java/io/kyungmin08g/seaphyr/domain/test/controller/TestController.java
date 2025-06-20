package io.kyungmin08g.seaphyr.domain.test.controller;

import io.kyungmin08g.seaphyr.domain.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class TestController {
  private final TestService testService;

  @GetMapping()
  public ResponseEntity<Void> test() {
    return ResponseEntity.ok().build();
  }
}
