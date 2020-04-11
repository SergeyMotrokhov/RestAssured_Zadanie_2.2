import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainTest {
    @Test
    public void jsobArrayTest(){
    }

    @Test
    public void firstTest2() {
    Response resp = given()
            .when()
            .get("https://reqres.in/api/unknown")
            .then()
            .log().all()
            .body("data.year",notNullValue())
            .extract()
            .response();
        JsonPath jsonNewUser = resp.jsonPath();
        List <Integer> list = jsonNewUser.getList("data.year");
        System.out.println(list);
        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);
        assertEquals(sorted, list);
        }

    }






