import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by jxzhong on 2017/5/11.
 */
public class MockAPITest {

    @Before
    public void setup() {
//        RestAssured.port = 80;
        RestAssured.baseURI = "https://api.github.com";
    }

    @Test
    public void testMockAPI() throws Exception {
        given().
                accept(ContentType.JSON)
                .expect().statusLine(containsString("200 OK")).

                when()
                .get("/users/octocat/orgs")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json; charset=utf-8"));

//        expect().body(equalTo("ERROR")).when().get("/409");
    }

    @Test
    public void testOnlineJsonAPI() throws Exception {
        given().
                parameters("text", "test").
                when().
                get("http://md5.jsontest.com").
                then().
                body("md5",equalTo("098f6bcd4621d373cade4e832627b4f6")).
                and().
                body("original", equalTo("test"));

    }
}
