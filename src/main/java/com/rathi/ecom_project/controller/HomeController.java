package com.rathi.ecom_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "application", "E-Commerce Backend API",
                "status", "Running ✅",
                "developer", "Prajjwal Rathi",
                "version", "1.0.0",
                "documentation", "/swagger-ui/index.html"
        );
    }

    @GetMapping("/health")
    public String health() {
        return "Backend is running successfully 🚀";
    }
}