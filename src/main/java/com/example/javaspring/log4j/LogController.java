package com.example.javaspring.log4j;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@SpringBootApplication
public class LogController {
    private final LogService logService;

    public static void main(String[] args) {
        SpringApplication.run(LogController.class);
    }

    @GetMapping("/log")
    public String getLogger(){
        logService.log();
        return "console.log";
    }
}
