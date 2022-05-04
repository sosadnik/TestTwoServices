package com.mycompany.generateJson;


import com.mycompany.generateJson.controller.GenerateRestController;
import com.mycompany.generateJson.model.GeoPosition;
import com.mycompany.generateJson.service.DataService;
import com.mycompany.generateJson.model.GeneratedData;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BaseContractTest {

    @BeforeEach
    public void setup(){
        ArrayList<GeneratedData> dates = new ArrayList<>();
        dates.add(new GeneratedData(
                "type", 1L, "key", "name",
                "fullName", "airport_code",
                "type", "country", new GeoPosition(2, 3),
                1L, true,
                "code", true, 1));
        dates.add(new GeneratedData(
                "type", 2L, "key", "name",
                "fullName", "airport_code",
                "type", "country", new GeoPosition(3, 3),
                1L, true,
                "code", true, 1));

        DataService dataService = mock(DataService.class);
        given(dataService.getList(anyLong())).willReturn(dates);

        RestAssuredMockMvc.standaloneSetup(new GenerateRestController(dataService));
    }
}
