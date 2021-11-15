package Handler;

import static io.restassured.RestAssured.given;

public class ApiHandler {

    public static void get(String url, String accessToken){
        given().baseUri(url).auth().oauth2(accessToken);
    }
// send get, send post,sendput

}
