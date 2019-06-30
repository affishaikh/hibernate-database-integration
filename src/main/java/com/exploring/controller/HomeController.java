package com.exploring.controller;

import com.exploring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    EmployeeRepository empRepo;

    @RequestMapping("/")
    String home() {
        System.out.println(empRepo.getAll());
        return "Vakairi";
    }
}
