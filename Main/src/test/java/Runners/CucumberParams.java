package Runners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CucumberParams {
    // with public static members
    // save the values to the member of this class

    // from cucumber read the contents of this class//
    private static CucumberParams cucumberParams;
    private static Map<String,String> dataMap  = new HashMap<>();
    public static  void addToList(List<String> data){

    }
    public static HashMap<String,String> addToMap(HashMap<String, String> data) {

        System.out.println(data.get("test1249@test.com")); //getting dtat from map

       // dataMap.put(data.get(0),data.get(1));
       return data;
    }


//    public static CucumberParams getParams(){
//        if(cucumberParams == null){
//            cucumberParams = new CucumberParams();
//        }
//        return cucumberParams;
//    }
}
