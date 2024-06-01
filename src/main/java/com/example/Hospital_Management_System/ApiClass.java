package com.example.Hospital_Management_System;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiClass {

    Map<Integer, Patient> patientDb = new HashMap<>();

    @GetMapping("Givemetheweatherupdate")

    public String getWeatherReport(){

        return "The temp is 30 degree cel but it feels like 35 & some possibility of rain.";
    }

    @GetMapping("sum")
    public String getSum(@RequestParam("no1") Integer no1, @RequestParam("no2") Integer no2){

        Integer sum = no1 + no2;

        return "The sum of the entered numbers is " + sum;
    }

    @PostMapping("addPatient")
    public String addPatient(@RequestBody Patient patient){

        int key = patient.getPatientId();

        patientDb.put(key, patient);

        return "The patient with patientId " + key + " has been saved into DB.";
    }

    @GetMapping("getpatientinfo")
    public Patient getPatientInfoById(@RequestParam ("patientId") Integer patientId){

        Patient patient = patientDb.get(patientId);

        return patient;
    }
}
