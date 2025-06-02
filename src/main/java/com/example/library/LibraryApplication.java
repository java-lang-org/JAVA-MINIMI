package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class LibraryApplication {
    private static List<Object> applicationRegistry = new ArrayList<>();
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("application-started");
        applicationRegistry.add(list);
        SpringApplication.run(LibraryApplication.class, args);
    }
} 