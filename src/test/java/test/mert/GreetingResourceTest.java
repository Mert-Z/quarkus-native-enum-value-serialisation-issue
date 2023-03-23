package test.mert;

import io.quarkus.test.junit.QuarkusTest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        String responseBody = given()
                .when()
                .get("/hello")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        Pattern p = Pattern.compile("(?<=\\\"testEnum\\\":\\\")[^\\\"]*");
        Matcher m = p.matcher(responseBody);

        assertTrue(m.find());
        assertEquals(TestEnum.VALUE_1.toString(), m.group(0));
    }

}