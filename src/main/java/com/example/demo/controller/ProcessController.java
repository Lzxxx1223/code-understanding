package com.example.demo.controller;

import com.example.demo.entity.Response;
import com.example.demo.service.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    private static final Logger logger = LoggerFactory.getLogger(ProcessController.class);

    @Autowired
    private Process process;

    @GetMapping("/")
    public Response processVin() {
        return process.link();
    }
}
