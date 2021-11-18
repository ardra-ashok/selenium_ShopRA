package Handler;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import static org.hamcrest.Matchers.*;


public class reqResApiHandler {

    public static ValidatableResponse valid_response;
    public static Response response;
    public static RequestSpecification req_spec;

    public static void setRestAPI(String url){
        RestAssured.baseURI = url;

    }



    public static void handleRequest(String method,String endPoint,String bodyData){

        req_spec = RestAssured.given().log().all();
        req_spec.header("Content-type", "application/json");
        req_spec.contentType(ContentType.JSON);
        switch(method){
            case "GET": response = req_spec.when().get(endPoint);
                        break;
            case "ADD": response = req_spec.when().body(bodyData).post(endPoint);
                        break;
            case "EDIT": response = req_spec.when().body(bodyData).put(endPoint);
                        break;
            case "DELETE": response = req_spec.when().delete(endPoint);
                            break;
            default: System.out.println("Wrong " +method);
        }
        System.out.println(response.asString());

    }

    public static void checkApiResponse(String method) {
        valid_response = response.then();

        switch(method){
            case "GET": valid_response.assertThat().statusCode(200).body("data",not(emptyArray()));
//                        .body("page",equalTo(1));
                        break;
            case "DELETE":valid_response.assertThat().statusCode(204);
                        break;
            case "ADD": valid_response.assertThat().statusCode(201);
                        break;
            case "EDIT": valid_response.assertThat().statusCode(200);
                        break;
            default: System.out.println("Wrong " +method);
        }

    }

    public static Response handleSingleGetRequest(String endPoint, String id) {
        response = RestAssured.given().log().all().queryParam("id",id).when().get(endPoint);
        return response;
    }
}
