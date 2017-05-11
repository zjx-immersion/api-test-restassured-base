import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by jxzhong on 2017/5/11.
 */
public class MockAPITest {

    @Before
    public void setup() {
        RestAssured.port = 80;
        RestAssured.baseURI = "http://md5.jsontest.com";
    }

    @Test
    public void testOnlineJsonAPI() throws Exception {
        given().
                parameters("text", "test").
                when().
                get("").
                then().
                body("md5",equalTo("098f6bcd4621d373cade4e832627b4f6")).
                and().
                body("original", equalTo("test"));

    }
}
