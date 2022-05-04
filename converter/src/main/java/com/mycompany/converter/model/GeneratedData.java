package com.mycompany.converter.model;

import lombok.*;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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

    @Override
    public String toString() {
        return "GeneratedData{" +
                "_type'" + _type + '\'' +
                "_id" + _id +
                "key" + key + '\'' +
                "name'" + name + '\'' +
                "fullName'" + fullName + '\'' +
                "iata_airport_code'" + iata_airport_code + '\'' +
                "type'" + type + '\'' +
                "country'" + country + '\'' +
                "geo_position" + geo_position +
                "location_id" + location_id +
                "inEurope" + inEurope +
                "countryCode'" + countryCode + '\'' +
                "coreCountry" + coreCountry +
                "distance" + distance +
                '}';


    }

    public String toString(String declaredField){
        switch (declaredField) {
            case "_type":
                return _type;
            case "_id":
                return String.valueOf(_id);
            case "key":
                return key;
            case "name":
                return name;
            case "fullName":
                return fullName;
            case "iata_airport_code":
                return iata_airport_code;
            case "type":
                return type;
            case "country":
                return country;
            case "latitude":
                return String.valueOf(geo_position.getLatitude());
            case "longitude":
                return String.valueOf(geo_position.getLongitude());
            case "location_id":
                return String.valueOf(geo_position);
            case "inEurope":
                return String.valueOf(inEurope);
            case "countryCode":
                return countryCode;
            case "distance":
                return String.valueOf(distance);
            default:
                return "";
        }
    }
}
