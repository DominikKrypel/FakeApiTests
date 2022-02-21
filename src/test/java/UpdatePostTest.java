import model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class UpdatePostTest extends BaseTest{

    @Test
    public void updatePost() {
        Post post = new Post("Nowy tytul", "Nowy autor");

        Post createPost = given()
                                .spec(reqSpec)
                                .pathParam("postId", "2")
                                .body(post).
                          when()
                                .put("{postId}").
                          then()
                                .spec(respSpec)
                                .extract().body().as(Post.class);

        assertEquals(post,createPost);
    }
}
