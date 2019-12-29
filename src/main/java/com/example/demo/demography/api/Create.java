package com.example.demo.demography.api;

import com.example.demo.model.Demography;
import com.example.demo.repository.CustomDemographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Demography")
public class Create {
    /*
    *
    * CRUD : Create methods *
    *
    */

    @Autowired
    //Respository instance
    private CustomDemographyRepository respository;

    /*Method for creating a demographic event You can create many events by passing an events array*/
    @PostMapping("/saveAll")
    public List<Demography> create(@RequestBody List<Demography> demographies) {
        respository.saveAll(demographies);
        //Returns the list of added items
        return demographies;
    }

    /*Method for creating a demographic event You can create many events by passing an events array*/
    @PostMapping("/save")
    public Demography create(@RequestBody Demography demography) {
        respository.save(demography);
        //Returns added item
        return demography;
    }





}
