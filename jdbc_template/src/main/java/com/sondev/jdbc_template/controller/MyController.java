package com.sondev.jdbc_template.controller;

import com.sondev.jdbc_template.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping("/demo")
    public void demo(){
        service.performDatabaseOperations();
    }

    @PostMapping("/categories")
    public int createCategory(@RequestParam String name){
        return service.createCategory(name);
    }


}
