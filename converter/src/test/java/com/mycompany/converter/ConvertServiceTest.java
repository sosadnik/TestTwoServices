package com.mycompany.converter;

import com.mycompany.converter.client.GeneratorJsonClient;
import com.mycompany.converter.model.GeneratedData;
import com.mycompany.converter.model.GeoPosition;
import com.mycompany.converter.service.ConvertService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ConvertServiceTest {

    private ConvertService convertService;

    @BeforeEach
    public void setup() {
        GeneratorJsonClient generatorJsonClient = mock(GeneratorJsonClient.class);
        convertService = new ConvertService(generatorJsonClient);
    }

    @Test
    void writeCSV_shouldReturnCSV() {
        List<GeneratedData> list = new ArrayList<>();
        list.add(new GeneratedData(
                "type", 1L, "key", "name",
                "fullName", "airport_code",
                "type", "country", new GeoPosition(2, 3),
                1L, true,
                "code", true, 1));
        list.add(new GeneratedData(
                "type", 2L, "key", "name",
                "fullName", "airport_code",
                "type", "country", new GeoPosition(3, 3),
                1L, true,
                "code", true, 1));
        String[] structureCSV = new String[]{"type", "_id", "name", "type", "latitude", "longitude"};
        String expected = "type,1,name,type,2.0,3.0," + "\n" + "type,2,name,type,3.0,3.0," + "\n";

        String actual = convertService.writeCSV(list, structureCSV);

        assertEquals(expected, actual);
    } @Test
    void writeCSV_shouldReturnEmptyCSV() {
        List<GeneratedData> list = new ArrayList<>();
        list.add(new GeneratedData(
                "type", 1L, "key", "name",
                "fullName", "airport_code",
                "type", "country", new GeoPosition(2, 3),
                1L, true,
                "code", true, 1));
        list.add(new GeneratedData(
                "type", 2L, "key", "name",
                "fullName", "airport_code",
                "type", "country", new GeoPosition(3, 3),
                1L, true,
                "code", true, 1));
        String[] structureCSV = new String[]{"1,2"};
        String expected = "";

        String actual = convertService.writeCSV(list, structureCSV);

        assertEquals(expected, actual);
    }
}
