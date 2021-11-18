package restAssuredService;

import Handler.reqResApiHandler;
import gherkin.deps.com.google.gson.Gson;


import java.util.List;
import java.util.Map;

public class reqResServices {

    public static void setAPI(){
        reqResApiHandler.setRestAPI("https://reqres.in");
    }



    public static void checkApiResponse(String method) {
        reqResApiHandler.checkApiResponse(method);

    }



    public static String convertJson(Map<String, String> data) {
        return  new Gson().toJson(data);
    }
    



    public static void handleRequest(String method, String endPoint, String body) {
        reqResApiHandler.handleRequest(method,endPoint,body);
    }

    public static void handleSingleGetRequest(String endPoint, String id) {

        reqResApiHandler.handleSingleGetRequest(endPoint,id);
    }
}
