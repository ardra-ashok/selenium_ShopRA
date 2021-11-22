package Handler;

import cucumber.api.DataTable;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import java.util.Locale;
import java.util.Map;

public class localApiHandler {



    public static Response handleApiRequest(String method, String urlEndPoint, String body) {
        RequestSpecification req_spec = RestAssured.given();
        req_spec.header("Accept", ContentType.JSON.getAcceptHeader());
        req_spec.contentType(ContentType.JSON);
        Response response = null;


        switch(method.toLowerCase()){
            case "get post": response = req_spec.when().get(urlEndPoint);
                break;
            case "create post": response = req_spec.when().body(body).post(urlEndPoint);
                break;
            case "update post": response = req_spec.when().body(body).put(urlEndPoint);
                break;
            case "delete post": response = req_spec.when().delete(urlEndPoint);
                break;
            default: System.out.println("Wrong " +method);
        }

        return response;
    }



}
