package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.annotation.Generated;
import java.util.Date;


@Document(indexName = "demographydatabasev11", type = "demography", shards = 2)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Demography {
    @Id
    //@Generated(strategy = GenerationType.AUTO)
    private String id;
    private String personName;
    private int value;
    @Field(type = FieldType.Date, store = true, format = DateFormat.custom , pattern = "yyyy-MM-dd")
    private String eventDate;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Ville ville;

}
