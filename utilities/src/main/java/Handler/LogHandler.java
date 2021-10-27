package Handler;

import Exceptions.ParentException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogHandler extends FileHandler {
    public static void log(String message)  {
        try {
            Date date = new Date() ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd [HH:mm:ss]") ;
            String fileName = dateFormat.format(date);
            fileWriter(fileName,message);
        } catch (ParentException e) {
            e.printStackTrace();
        }
        //   fileReader();


    }




}
