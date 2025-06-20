package io.github.kyungmin08g.seaphyr.domain.test.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

  public void print() throws InterruptedException {
    Thread.sleep(5000);
    System.out.println("Hello, World!");
  }
}
