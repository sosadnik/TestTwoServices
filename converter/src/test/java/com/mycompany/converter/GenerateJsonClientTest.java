package com.mycompany.converter;

import com.mycompany.converter.model.GeneratedData;
import com.mycompany.converter.model.GeoPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateJsonClientTest {

    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        restTemplate = new RestTemplate();
    }

    @RegisterExtension
    public StubRunnerExtension stubRunner = new StubRunnerExtension()
            .downloadStub("com.mycompany", "generateJson", "1.0-SNAPSHOT", "stubs")
            .withPort(8101)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    void getGenerateJson_shouldReturnJsonList() {
        ArrayList<GeneratedData> expected = new ArrayList<>();
        expected.add(new GeneratedData(
                "type", 1L, "key", "name",
                "fullName", "airport_code",
                "type", "country", new GeoPosition(2, 3),
                1L, true,
                "code", true, 1));
        expected.add(new GeneratedData(
                "type", 2L, "key", "name",
                "fullName", "airport_code",
                "type", "country", new GeoPosition(3, 3),
                1L, true,
                "code", true, 1));


        ResponseEntity<GeneratedData[]> responseEntity = restTemplate.getForEntity(
                "http://localhost:8101/generate/json/2",
                GeneratedData[].class);
        List<GeneratedData> actual = Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));

        assertEquals(expected, actual);
    }
}
