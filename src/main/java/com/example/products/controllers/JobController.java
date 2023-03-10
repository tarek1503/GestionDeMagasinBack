package com.example.products.controllers;

import com.example.products.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping("/importClients")
    public  void importCsvToDBJob(){
       jobService.importCsvToDB();
    }


}
