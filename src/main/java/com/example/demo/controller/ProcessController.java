package com.example.demo.controller;

import com.example.demo.entity.Response;
import com.example.demo.service.Process;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {


    @Autowired
    private Process process;

    @GetMapping("/")
    public Response processVin() {
        return process.link();
    }
}
