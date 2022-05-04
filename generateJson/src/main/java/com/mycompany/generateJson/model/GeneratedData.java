package com.mycompany.generateJson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class GeneratedData {

    private String _type;
    private Long _id;
    private String key;
    private String name;
    private String fullName;
    private String iata_airport_code;
    private String type;
    private String country;
    private GeoPosition geo_position;
    private Long location_id;
    private boolean inEurope;
    private String countryCode;
    private boolean coreCountry;
    private double distance;
}
