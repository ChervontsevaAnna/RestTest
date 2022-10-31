import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class TestRest {
    @Test
    public void CreateUser(){
        CreateUserRequest rq = new CreateUserRequest();
        rq.setName("Sanya");
        rq.setJob("Trubochist");

        CreateUserResponse rs = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .body(rq)
                .when().post("/api/users")
                .then().extract().as(CreateUserResponse.class);

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());


    }
}
