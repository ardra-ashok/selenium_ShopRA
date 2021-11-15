package Runners;

import Exceptions.ParentException;
import Handler.FileHandler;
import org.testng.annotations.DataProvider;

public class dataProvider {
    private static String filePath = "C:\\Users\\aashok\\intellij\\newfolder\\selenium_Shop\\tempfiles\\Credentials.txt";


    @DataProvider(name="LogData")
    public static Object[][] LogData() throws ParentException {

        String[] list = FileHandler.fileReader(filePath).split("\\r?\\n");
        String[] result = new String[1000];

        int index = 0;
        int count = 0;
        Object[][] data = new Object[list.length][2];
        for(String str: list){
            for(String st : str.split(",")){
                result[index++] = st;
            }
        }
        for(int i=0;i<list.length;i++){
            for(int j=0;j<2;j++){
               // System.out.println(result[count] instanceof Object);
                result[count] = result[count].replaceAll("^\"|\"$", "");
                data[i][j] = result[count];
                count++;
            }
        }
        return data;
    }


}
