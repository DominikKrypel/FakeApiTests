import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPostsTest extends BaseTest {

    @Test
    public void getPost(){
        given()
                .spec(reqSpec).
        when()
                .get().
        then()
                .spec(respSpec)
                .assertThat().body("title[0]",equalTo("Pierwszy"))
                .assertThat().body("author[0]",equalTo("Tomek")).
        and()
                .assertThat().body("title[1]",equalTo("Drugi"))
                .assertThat().body("author[1]",equalTo("Alicja")).
        and()
                .assertThat().body("title[1]",equalTo("Trzeci"))
                .assertThat().body("author[1]",equalTo("Weronika"));
    }
}
