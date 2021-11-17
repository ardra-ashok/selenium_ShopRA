package restAssuredService;

import Handler.reqResApiHandler;
import gherkin.deps.com.google.gson.Gson;

import java.util.Map;

public class reqResServices {

    public static void setAPI(){
        reqResApiHandler.setRestAPI("https://reqres.in");
    }



    public static void checkApiResponse(String method) {
        reqResApiHandler.checkApiResponse(method);

    }



    public static String convertJson(Map<String, String> data) {
        String body = new Gson().toJson(data);
        return body;

    }

    public static void handleRequest(String method, String endPoint, String body) {
        reqResApiHandler.handleRequest(method,endPoint,body);
    }
}
