package Runners;

import org.testng.annotations.DataProvider;

public class dataProviderRepo {
    @DataProvider
    public static Object[][] LoginData(){
       return new Object[][]
               {
                       {"test1249@test.com","PKR@PKR"},
                       {"testemailardra@gmail.com","PKR@PKR"}
               };
    }

    @DataProvider
    public static Object[][] LogData(){
        Object[][] data = new Object[2][2];
        data[0][0] = "test1249@test.com";
        data[0][1] = "PKR@PKR";

        data[1][0] = "testemailardra@gmail.com";
        data[1][1] = "PKR@PKR";
        return data;
    }
}
