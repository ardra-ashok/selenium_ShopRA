package restAssuredService;

import Handler.localApiHandler;
import cucumber.api.DataTable;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

public class localService {

    public static void setEnvironment() {
        RestAssured.baseURI = "http://localhost:3000";
    }


    public static String setRequest(String endPoint, DataTable posts) {
        String title = "";
        String author = "";
        String urlEndPoint="";
        for(Map<String, String> data: posts.asMaps(String.class,String.class)){
            title = data.get("title");
            author = data.get("author");
        }
        switch (endPoint){
            case "Create Post": if((title.equals("") && author.equals(""))){
                //                  throw exception here
                                    System.out.println("mandatory field is missing");
                                }
                                else{
                                  urlEndPoint= localServerModel.createPost;
                                }
                                break;



        }

        return urlEndPoint;
    }

    public static void handleRequest(String method,String urlEndPoint, String posts,String ResponseCode) {
        localApiHandler.makeRequest(method,urlEndPoint,posts,ResponseCode);

    }

    public static HashMap<String, String> getBody(Map<String, String> data){
        HashMap<String,String> dataMap = new HashMap<>();
        dataMap.put("title",data.get("title"));
        dataMap.put("author",data.get("author"));
        return dataMap;
    }
    public static String getResponseCode(Map<String, String> data){
        String responseCode =data.get("responseCode");
        return responseCode;
    }


    public static String convertJson(Map<String, String> data) {
        return  new Gson().toJson(data);
    }
}
