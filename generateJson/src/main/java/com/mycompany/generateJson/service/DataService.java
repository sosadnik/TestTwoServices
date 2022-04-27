package com.mycompany.generateJson.service;

import com.mycompany.generateJson.model.GeoPosition;
import com.mycompany.generateJson.model.GeneratedDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DataService {

    private final RandomValueGeneratorService generatorService;

    public List<GeneratedDate> getList(long size) {
        List<GeneratedDate> list = new ArrayList<>();

        while (list.size() < size) {
            list.add(buildGeneratorDate());
        }
        return list;
    }

    private GeneratedDate buildGeneratorDate() {
        return GeneratedDate.builder()
                ._type(generatorService.randomString())
                ._id(generatorService.randomLong())
                .key(generatorService.randomString())
                .name(generatorService.randomString())
                .fullName(generatorService.randomString())
                .iata_airport_code(generatorService.randomString())
                .type(generatorService.randomString())
                .country(generatorService.randomString())
                .geo_position(new GeoPosition(generatorService.randomDouble(), generatorService.randomDouble()))
                .location_id(generatorService.randomLong())
                .inEurope(generatorService.randomBoolean())
                .countryCode(generatorService.randomString())
                .coreCountry(generatorService.randomBoolean())
                .distance(generatorService.randomDouble())
                .build();
    }
}
