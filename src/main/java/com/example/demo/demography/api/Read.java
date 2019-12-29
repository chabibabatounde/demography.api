package com.example.demo.demography.api;

import com.example.demo.model.Demography;
import com.example.demo.repository.CustomDemographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Demography")
public class Read {
    /*
     *
     * CRUD : Read methods *
     *
     */

    @Autowired
    //Respository instance
    private CustomDemographyRepository respository;

    /*Method used to count records*/
    @GetMapping("/count")
    private long count() {
        return respository.count();
    }


    /*Method to get record by event type*/
    @GetMapping("/findByValue/{value}")
    private List<Demography> findByValue(@PathVariable int value) {
        return respository.findByValue(value);
    }

    /*Method used to get all records*/
    @GetMapping("/findAll")
    private Iterable<Demography> findAll(){
        return respository.findAll();
    }

    /*Method used to get record by Id*/
    @GetMapping("/findById/{id}")
    private Optional<Demography> findAll(@PathVariable  String id){
        return respository.findById(id);
    }

    /*Method used to get record by personName*/
    @GetMapping("/findByPersonName/{personName}")
    private List<Demography> findByPersonName(@PathVariable String personName) {
        return respository.findByPersonName(personName);
    }

    /*Method used to get record by event Date for all cities*/
    @GetMapping("/findByEventDate/{date}")
    private List<Demography> findByDate(@PathVariable String date){
        return respository.findByEventDate(date);
    }

    /*Method used to get record by city */
    @GetMapping("/findByVilleNomVille/{nomVille}")
    private List<Demography> findByVilleNomVille(@PathVariable String nomVille){
        return respository.findByVilleNomVille(nomVille);
    }


    /*Method to get record between two dates for all cities */
    @GetMapping("/findByEventDateBetween/{fromDate}/{toDate}")
    private List<Demography> findByEventDateBetween(@PathVariable String fromDate, @PathVariable String toDate) {
        return  respository.findByEventDateBetween(fromDate, toDate);
    }

    /*Method to get record between two dates filter by City */
    @GetMapping("/findByVilleNomVilleAndEventDateBetween/{nomVille}/{fromDate}/{toDate}")
    private List<Demography> findByVilleNomVilleAndEventDateBetween(@PathVariable String nomVille, @PathVariable String fromDate, @PathVariable String toDate) {
        return  respository.findByEventDateBetween(fromDate, toDate);
    }

}
