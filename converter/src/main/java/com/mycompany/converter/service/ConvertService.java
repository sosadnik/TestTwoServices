package com.mycompany.converter.service;

import com.mycompany.converter.client.GeneratorJsonClient;
import com.mycompany.converter.model.GeneratedData;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
public class ConvertService {

    private final GeneratorJsonClient jsonClient;

    public String convertToCSV(String format, int size) {
        List<GeneratedData> list = jsonClient.getJsonList(size);
        String[] structureCSV = format.replace(" ", "").split(",");

        return writeCSV(list, structureCSV);
    }

    public String writeCSV(List<GeneratedData> list, String[] structureCSV) {
        StringBuilder stringBuilder = new StringBuilder();
        for (GeneratedData data : list) {
            for (String s : structureCSV) {
                stringBuilder.append(data.toString(s)).append(",");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}

