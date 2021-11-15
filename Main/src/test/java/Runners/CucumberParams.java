package Runners;


import java.util.HashMap;


public class CucumberParams {
    // - with public static members
    // - save the values to the member of this class
    // - from cucumber read the contents of this class



    public static HashMap<String,String> dataMap  = new HashMap<>();

    public static String getValue(String key){
        return dataMap.get(key);
    }



}
