package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ville {
    private double lat;
    private double lng;
    private String nomVille;

    @Override
    public String toString() {
        return "Ville{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", nomVille='" + nomVille + '\'' +
                '}';
    }
}
