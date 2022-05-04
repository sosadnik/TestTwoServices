package com.mycompany.converter.controller;

import com.mycompany.converter.service.ConvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/csv")
public class ConverterRestController {

    public static final String FORMAT_CSV = "type, _id, name, type, latitude, longitude";
    private final ConvertService convertService;

    @GetMapping("/{size}")
    public String getCsvForm(@PathVariable int size) {
        return convertService.convertToCSV(FORMAT_CSV, size);
    }

    @GetMapping("/{size}/{form}")
    public String getCsvForm(@PathVariable String form, @PathVariable int size) {
        return convertService.convertToCSV(form, size);
    }


}
