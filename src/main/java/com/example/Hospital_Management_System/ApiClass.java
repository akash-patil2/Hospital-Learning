package com.example.Hospital_Management_System;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("patient")
public class ApiClass {

    Map<Integer, Patient> patientDb = new HashMap<>();

    @GetMapping("GiveMeTheWeatherUpdate")

    public String getWeatherReport(){

        return "The temp is 30 degree cel but it feels like 35 & some possibility of rain.";
    }

    @GetMapping("sum")
    public String getSum(@RequestParam("no1") Integer no, @RequestParam("no2") Integer nop){

        Integer sum = no + nop;

        return "The sum of the entered numbers is " + sum;
    }

    @PostMapping("addPatient")
    public String addPatient(@RequestBody Patient patient){

        int key = patient.getPatientId();

        patientDb.put(key, patient);

        return "The patient with patientId " + key + " has been saved into DB.";
    }

    @GetMapping("getPatientInfo")
    public Patient getPatientInfoById(@RequestParam ("patientId") Integer patientId){

        Patient patient = patientDb.get(patientId);

        return patient;
    }

    @GetMapping("getPatientByName&Mobno")
    public Patient getPatientByNameAndMobNo(@RequestParam ("name") String nam, @RequestParam ("mobNo") String mob){

        for(Patient patient: patientDb.values()){

            if(patient.getPatientName().equals(nam) && patient.getMobileNo().equals(mob)){
                return patient;
            }
        }
        return null;
    }

    @GetMapping("getOldestPatientName")
    public String getOldestPatientName(){

        int maxAge = 0;
        Patient ansPatient = null;

        for(Patient patient: patientDb.values()){
            if(patient.getPatientAge() > maxAge){
                maxAge = patient.getPatientAge();
                ansPatient = patient;
            }
        }
        return ansPatient.getPatientName();
    }

}
