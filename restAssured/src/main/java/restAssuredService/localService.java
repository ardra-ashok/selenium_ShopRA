package restAssuredService;

import Handler.localApiHandler;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class localService {

    public static void setEnvironment() {
        RestAssured.baseURI = "http://localhost:3000";
    }


    public static String setRequest(String method, Map<String,String> data) {

        String urlEndPoint= null;

        switch (method.toLowerCase()) {
            case "create post":
                if ((data.get("title").equals("")) && (data.get("author")).equals("")) {
                    //                  throw exception here
                    System.out.println("mandatory field is missing");
                } else {
                    urlEndPoint = localServerModel.createPost;
                }
                break;
            case "delete post":
                if ((data.get("title").equals("")) && (data.get("author")).equals("")) {
                    //                  throw exception here
                    System.out.println("mandatory field is missing");
                } else {
                    urlEndPoint = localServerModel.deletePost;
                }
                break;
            case "update post": if ((data.get("title").equals("")) && (data.get("author")).equals("")) {
                    //                  throw exception here
                    System.out.println("mandatory field is missing");
                } else {
                    urlEndPoint = localServerModel.putPost;
                }
                break;

            case "get post" : urlEndPoint=localServerModel.getPost;
                        break;


        }

        return urlEndPoint;
    }

    public static Response handlePostRequest(String method, Map<String,String> body) {
        String urlEndPoint = setRequest(method,body);
        Map<String, String> data = getBody(body);
        String bodyData = convertJson(data);
        String responseCode = getResponseCode(body);
        int statusCode = Integer.parseInt(responseCode);
        Response response = localApiHandler.handleApiRequest(method, urlEndPoint, bodyData);
        Assert.assertEquals(response.statusCode(),statusCode);

        urlEndPoint = setRequest("get post", null) + "/" + response.path("id").toString();
        response = localApiHandler.handleApiRequest("get post", urlEndPoint, null);
        return response;
    }

    public static HashMap<String, String> getBody(Map<String, String> data){
        HashMap<String,String> dataMap = new HashMap<>();
        dataMap.put("title",data.get("title"));
        dataMap.put("author",data.get("author"));
        return dataMap;
    }
    public static String getResponseCode(Map<String, String> data){
        String responseCode = data.get("responseCode");
        return responseCode;
    }

    public static String convertJson(Map<String, String> data) {
        return  new Gson().toJson(data);
    }


    public static Response handleDeleteRequest(String method, Map<String, String> body)
    {

        String createEndPoint = setRequest("create post",body);
        String bodyData = convertJson(getBody(body));
        Response createResponse = localApiHandler.handleApiRequest("create post",createEndPoint,bodyData);
        int postId = createResponse.path("id");
        String urlEndPoint = localService.setRequest(method,body);
        urlEndPoint = urlEndPoint+"/"+postId;
        Response deleteResponse = localApiHandler.handleApiRequest(method,urlEndPoint,null);
        String getEndPoint = setRequest("get post",null);
        urlEndPoint = getEndPoint+"/"+postId;
        Response getResponse = localApiHandler.handleApiRequest("get post",urlEndPoint,null);
        return getResponse;

    }

    public static Response handlePutRequest(String method, Map<String, String> body) {
        String createEndPoint = setRequest("create post",body);
        String bodyData = convertJson(getBody(body));
        Response createResponse = localApiHandler.handleApiRequest("create post",createEndPoint,bodyData);
        String postId = createResponse.path("id").toString();
        String putEndPoint = setRequest(method,body);
        putEndPoint = putEndPoint+"/"+postId;
        Map<String, String> updateTitle = new HashMap<>();
        updateTitle.put("title",body.get("updatedTitle"));
        String updatedData  = convertJson(updateTitle);
        Response putResponse = localApiHandler.handleApiRequest(method,putEndPoint,updatedData);
        return putResponse;
    }
}
