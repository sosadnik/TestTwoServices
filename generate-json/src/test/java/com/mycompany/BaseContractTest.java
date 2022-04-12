package com.mycompany;

import com.mycompany.controller.GenerateRestController;
import com.mycompany.model.GeneratedDate;
import com.mycompany.model.GeoPosition;
import com.mycompany.service.DataService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BaseContractTest {

    @BeforeEach
    public void setup(){
        ArrayList<GeneratedDate> dates = new ArrayList<>();
        dates.add(new GeneratedDate(
                "type", 1L, "kay","name",
                "fullName","airport_code",
                "type", "country", new GeoPosition(2D, 3D),
                1L, true,
                "code",true, 1D));

        DataService dataService = mock(DataService.class);
        given(dataService.getList(anyLong())).willReturn(dates);

        RestAssuredMockMvc.standaloneSetup(new GenerateRestController(dataService));
    }
}
