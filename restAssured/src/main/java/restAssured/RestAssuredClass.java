package restAssured;


import Handler.ApiHandler;
import io.restassured.response.Response;


import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import restAssuredObjects.RestObjects;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredClass {
    private RequestSpecification req_spec;
    private Response resp;
    private ValidatableResponse valid_response;
    private Response resp_get;


    public void getRestApiUpRunning(){
       //  ApiHandler.get(RestObjects.url,RestObjects.accessToken);
//        req_spec =  given().baseUri(RestObjects.url).auth().oauth2(RestObjects.accessToken)
//                .when().get("")
//                .then().assertThat();

    }
    public void hitEndpointGet(String endPoint){
       // resp = req_spec.when().get("/public/v1/users");
        resp = req_spec.when().get(endPoint);
        valid_response = resp.then();
    }
    // success
    public void returnAllUsers(){
        valid_response.assertThat()
                .statusCode(200)
                .body("meta.pagination.limit",equalTo(20))
                .body("data",not(emptyArray()));
    }

    public void returnSingleUser(String user_id){
        resp = req_spec.when().get("/public/v1/users/11");
        valid_response = resp.then();
        valid_response
                .assertThat()
                .statusCode(200)
                .body("data", not(emptyArray()))
                .body("data.id", equalTo(Integer.parseInt(user_id)));
    }

    public void userWrongId(String userId){

        resp = req_spec.when().get("/public/v1/users/6453453555353535353453");
        valid_response = resp.then();
            valid_response
                .assertThat()
                .statusCode(404)
                .body("meta",equalTo(null))
                .body("data.message", equalTo("Resource not found"));

    }



    public void setHeaderAndContentForNewUser(){
        HashMap<String,String> hm_header = new HashMap<String,String>();
        hm_header.put("Content-Type", "application/json");
        req_spec.headers(hm_header).body(RestObjects.newUser);
    }

    public void hitEndpointPost(String endPoint){
         resp = req_spec.when().post("/public/v1/users");
       // resp = req_spec.when().post(endPoint);
        valid_response = resp.then();
    }

    public void newUserCheckInSystem(){
        valid_response
                .assertThat()
                .statusCode(201)
                .body("meta", equalTo(null))
                .body("data.name", equalTo("steven"))
                .body("data.gender", equalTo("male"))
                .body("data.email", equalTo("stevehooke@gmail.com"))
                .body("data.status", equalTo("active"));
    }

    public void deleteUser(String userId){
        System.out.println("/public/v1/users/"+userId);
        req_spec
                .when().delete("/public/v1/users/"+userId);
        resp.then()
                .assertThat()
                .statusCode(404)
                .body("data.message", equalTo("Resource not found"));
    }
    public void confirmDelete(String newUserID){
        resp_get = given()
                .baseUri(RestObjects.url)
                .auth().oauth2(RestObjects.accessToken)
                .when()
                .get("/public-api/users/"+newUserID);


        resp_get.then()
                .assertThat()
                .body("code", equalTo(404))
                .body("meta",equalTo(null))
                .body("data.message",equalTo("Resource not found"));

    }

    public void updateExistingUser(String newUserID){
        HashMap<String,String> hm_header = new HashMap<String,String>();
        hm_header.put("Content-Type", "application/json");
        req_spec.headers(hm_header).body(RestObjects.body_string);
        resp = req_spec.when().put("/public/v1/users/" +newUserID);
        resp.then()
                .assertThat()
                .statusCode(200)
                .body("meta", equalTo(null))
                .body("data.status", equalTo("inactive"));


    }

    public void shouldUpdateUser(){


    }





}
