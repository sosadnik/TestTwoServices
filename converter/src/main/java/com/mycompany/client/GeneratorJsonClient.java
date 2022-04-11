package com.mycompany.client;

import com.mycompany.model.GeneratedDate;
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
    private final static String URL_JSON = "http://generate-json:8080";

    public List<GeneratedDate> getJsonList(int size) {
        ResponseEntity<GeneratedDate[]> responseEntity = restTemplate.getForEntity(
                URL_JSON + "/generate/json/{size}",
                GeneratedDate[].class,
                size);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }
}
