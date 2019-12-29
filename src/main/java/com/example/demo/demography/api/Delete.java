package com.example.demo.demography.api;


import com.example.demo.model.Demography;
import com.example.demo.repository.CustomDemographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Demography")
public class Delete {
    /*
     *
     * CRUD : Delete methods *
     *
     */

    @Autowired
    //Respository instance
    private CustomDemographyRepository respository;

    /*Method for creating a demographic event You can create many events by passing an events array*/
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        respository.deleteById(id);
    }
}
