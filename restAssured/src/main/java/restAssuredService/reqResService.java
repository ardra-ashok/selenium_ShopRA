package restAssuredService;

import Handler.ApiHandler;
import cucumber.api.DataTable;

public class reqResService {

    public static void setAPI(){
        ApiHandler.setRestAPI();
    }

    public static void getAllUsers(String endPoint){
        ApiHandler.getUsersForGetRequest(endPoint);
    }

    public static void getUserMatchingId(String endPoint,int id){
        ApiHandler.getUserMatchingId(endPoint,id);
    }

    public static void getSinglePageData(String endPoint, int pageId) {
        ApiHandler.getSinglePageData(endPoint,pageId);

    }

    public static void getErrorResponseForWrongUser(String endPoint) {
        ApiHandler.getErrorResponseForWrongUser(endPoint);
    }

    public static void addUpdateOrEditUser(String method) {
        ApiHandler.addUpdateOrEditUser(method);
    }
}
