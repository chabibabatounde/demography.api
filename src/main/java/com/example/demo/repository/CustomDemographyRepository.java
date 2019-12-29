package com.example.demo.repository;

import com.example.demo.model.Demography;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomDemographyRepository extends ElasticsearchRepository<Demography, String> {
    List<Demography> findByPersonName(String personName);

    void deleteById(int id);

    @Query("{\"bool\" : {\"must\" : {\"match\" : {\"value\" : \"?0\"}}}}")
    List<Demography> findByValue(int value);

    @Query("{\"bool\":{\"must\":{\"range\":{\"eventDate\": {\"gte\": \"?0\",\"lte\": \"?0\", \"format\": \"yyyy-MM-dd\", \"include_lower\" : true, \"include_upper\" : true}}}}}")
    List<Demography> findByEventDate(String eventDate);

    @Query("{\"bool\":{\"must\":{\"range\":{\"eventDate\": {\"gte\": \"?0\",\"lte\": \"?1\", \"format\": \"yyyy-MM-dd\", \"include_lower\" : true, \"include_upper\" : true}}}}}")
    List<Demography> findByEventDateBetween(String fromDate, String toDate);


    @Query("{\"bool\":{\"must\":[{\"match\" : {\"ville.nomVille\" : \"?0\"}} ,{\"range\":{\"eventDate\": {\"gte\": \"?1\",\"lte\": \"?2\", \"format\": \"yyyy-MM-dd\", \"include_lower\" : true, \"include_upper\" : true}}}]}}")
    List<Demography> findByVilleNomVilleAndEventDateBetween(String ville, String fromDate, String toDate);

    @Query("{\"bool\" : {\"must\" : {\"match\" : {\"ville.nomVille\" : \"?0\"}}}}")
    List<Demography> findByVilleNomVille(String nomVille);
}
