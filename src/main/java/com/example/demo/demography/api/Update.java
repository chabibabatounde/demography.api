package com.example.demo.demography.api;

import com.example.demo.model.Demography;
import com.example.demo.repository.CustomDemographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Demography")
public class Update {
    /*
     *
     * CRUD : Update method *
     *
     */

    @Autowired
    //Respository instance
    private CustomDemographyRepository respository;

    /*Method for update a demographic event*/
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Demography demography) {
        respository.save(demography);
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

}
