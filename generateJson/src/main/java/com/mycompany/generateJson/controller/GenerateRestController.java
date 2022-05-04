package com.mycompany.generateJson.controller;

import com.mycompany.generateJson.service.DataService;
import com.mycompany.generateJson.model.GeneratedData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/generate")
public class GenerateRestController {

    private final DataService service;

    @GetMapping("/json/{size}")
    public List<GeneratedData> getJson(@PathVariable long size){
        return service.getList(size);
    }
}
