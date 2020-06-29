package steps;

import cucumber.api.java.Before;
import utilities.RestAssuredExtension;

public class TestInitialize {
    @Before
    public void testSetUp() {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}
