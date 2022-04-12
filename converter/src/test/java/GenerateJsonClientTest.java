import com.mycompany.client.GeneratorJsonClient;
import com.mycompany.model.GeneratedDate;
import com.mycompany.model.GeoPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateJsonClientTest {

    private GeneratorJsonClient generatorJsonClient;

    @BeforeEach
    public void setup(){
        RestTemplate restTemplate = new RestTemplate();
        generatorJsonClient = new GeneratorJsonClient(restTemplate);
    }

    @RegisterExtension
    public StubRunnerExtension stubRunner = new StubRunnerExtension()
            .downloadStub("test","converter", "1.0-SNAPSHOT", "stubs" )
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    void getGenerateJson_shouldReturnJsonList(){
        ArrayList<GeneratedDate> expected = new ArrayList<>();
        expected.add(new GeneratedDate(
                "type", 1L, "kay","name",
                "fullName","airport_code",
                "type", "country", new GeoPosition(2D, 3D),
                1L, true,
                "code",true, 1D));

        List<GeneratedDate> actual = generatorJsonClient.getJsonList(2);

        assertEquals(expected, actual);
    }
}
