package Handler;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class localApiHandler {

    public static ValidatableResponse makeRequest(String method, String urlEndPoint, String bodyData,String ResponseCode) {
        RequestSpecification req_spec = RestAssured.given();
        req_spec.header("Accept", ContentType.JSON.getAcceptHeader());
        req_spec.contentType(ContentType.JSON);
        Response response = null;

        switch(method){
            case "GET": response = req_spec.when().get(urlEndPoint);
                break;
            case "Create Post": response = req_spec.when().body(bodyData).post(urlEndPoint);
                break;
            case "EDIT": response = req_spec.when().body(bodyData).put(urlEndPoint);
                break;
            case "DELETE": response = req_spec.when().delete(urlEndPoint);
                break;
            default: System.out.println("Wrong " +method);
        }

        return response.then().log().all();
    }
}
