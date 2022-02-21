import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPostTest extends BaseTest {

    @Test
    public void getPost(){
        given()
                .pathParam("postId", 1)
                .spec(reqSpec).
        when()
                .get("{postId}").
        then()
                .spec(respSpec)
                .assertThat().body("title",equalTo("Pierwszy"))
                .assertThat().body("author",equalTo("Tomek"));
    }
}
