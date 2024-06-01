package com.example.Hospital_Management_System;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiClass {

    @GetMapping("Givemetheweatherupdate")

    public String getWeatherReport(){

        return "The temp is 30 degree cel but it feels like 35 & some possibility of rain.";
    }

    @GetMapping("sum")
    public String getSum(@RequestParam("no1") Integer no1, @RequestParam("no2") Integer no2){

        Integer sum = no1 + no2;

        return "The sum of the entered numbers is " + sum;
    }
}
