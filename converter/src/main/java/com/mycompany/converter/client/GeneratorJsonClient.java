package com.mycompany.converter.client;

import com.mycompany.converter.model.GeneratedData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class GeneratorJsonClient {

    private final RestTemplate restTemplate;
    private final static String URL_JSON = "http://localhost:8080";

    public List<GeneratedData> getJsonList(int size) {
        ResponseEntity<GeneratedData[]> responseEntity = restTemplate.getForEntity(
                URL_JSON + "/generate/json/{size}",
                GeneratedData[].class,
                size);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }
}
