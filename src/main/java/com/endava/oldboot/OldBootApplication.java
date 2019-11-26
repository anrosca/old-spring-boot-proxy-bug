package com.endava.oldboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAsync
public class OldBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OldBootApplication.class, args);
    }

}

@Service
class TestService {

    @Async
    public int doSomethingElse() {
        return 4711;
}
}

@RestController
class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/greetings")
    public String get() {
        return "Hello, world";
    }
}
