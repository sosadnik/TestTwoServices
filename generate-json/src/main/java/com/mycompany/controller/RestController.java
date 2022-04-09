package com.mycompany.controller;

import com.mycompany.model.GeneratedDate;
import com.mycompany.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/generate")
public class RestController {

    private final DataService service;

    @GetMapping("/json/{size}")
    public List<GeneratedDate> getJson(@PathVariable long size){
        return service.getList(size);
    }
}
