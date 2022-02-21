import model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class PatchPostTest extends BaseTest{

    @Test
    public void patchPost() {
        Post post = new Post("Zaktualizowany");

        Post createPost = given()
                                .spec(reqSpec)
                                .pathParam("postId", "3")
                                .body(post).
                          when()
                                .patch("{postId}").
                          then()
                                .spec(respSpec)
                                .extract().body().as(Post.class);

        assertEquals(createPost.getTitle(), "Zaktualizowany");
        assertEquals(createPost.getAuthor(), "Weronika");
    }
}
