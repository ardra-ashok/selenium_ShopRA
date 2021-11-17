package Handler;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiHandler {

    public static  ValidatableResponse valid_response;
    public static String path;

    public static void setRestAPI(){
        RestAssured.baseURI = "https://reqres.in";
    }



    public static ValidatableResponse getUsersForGetRequest(String endPoint){
        return given().log().all()
                .when().get(endPoint).then()
                .assertThat()
                .statusCode(200)
                .body("page",equalTo(2))
                .body("data",not(emptyArray()));

    }


    public static ValidatableResponse getUserMatchingId(String endPoint, int id) {
        return given().log().all()
                .when().get(endPoint).then()
                .assertThat()
                .statusCode(200)
                .body("data.email",equalTo("george.edwards@reqres.in"))
                .body("data.id",equalTo(11));


    }

    public static ValidatableResponse getSinglePageData(String endPoint, int pageId) {
        return given().log().all()
                .when().get(endPoint).then()
                .assertThat()
                .statusCode(200)
                .body("total_pages",equalTo(2))
                .body("page",equalTo(1))
                .body("data",not(emptyArray()));
    }

    public static ValidatableResponse getErrorResponseForWrongUser(String endPoint) {
        return given().log().all()
                .when().get(endPoint).then()
                .assertThat()
                .statusCode(404)
                .body("data",equalTo(null));
    }

    public static ValidatableResponse addUpdateOrEditUser(String method) {

        if(method.equals("post")) {
            valid_response = given().log().all().header("Content-type", "application/json")
                    .body("{\n" + "\"name\": \"mira\",\n" +
                            "\"job\": \"tech-support\"\n" + "}")
                    .when().post("/api/users/create")
                    .then().log().all().assertThat()
                    .statusCode(201)
                    .body("name", equalTo("mira"))
                    .body("job", equalTo("tech-support"));
        }
        else if(method.contains("put") || method.contains("patch")){
            valid_response = given().log().all().header("Content-type", "application/json")
                    .body(" {\n" +
                            " \"id\": 1,\n" +
                            "\"email\": \"georg.bluth@reqres.in\"\n" + "\n" +
                            " }")
                    .when().put("/api/users/update/1")
                    .then().log().all().assertThat()
                    .statusCode(200)
                    .body("email", equalTo("georg.bluth@reqres.in"))
                    .body("id", equalTo(1));
        }
        return valid_response;
    }








}
