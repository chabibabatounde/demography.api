package com.example.demo.demography.api;

import com.example.demo.model.Demography;
import com.example.demo.repository.CustomDemographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public Demography update(@RequestBody Demography demography) {
        respository.save(demography);
        return demography;
    }

}
