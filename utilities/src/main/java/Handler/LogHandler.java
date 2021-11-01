package Handler;







import Exceptions.ParentException;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogHandler extends FileHandler {
        private static String fileName = "";

        public static String  initializeReport()  {
                Date date = new Date() ;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd[HH-mm-ss]");
                String dateName = dateFormat.format(date);
                fileName = "C:\\Users\\61491\\intellij\\ShoppingProjectMave\\tempfiles\\"+dateName+".txt";
                return fileName;
    }

    public static void log(String message)  {
            try{
                if(fileName.equals("")){
                    System.out.println("file name is null");
                    //throw new Error("file name is null");
                }
                fileWriter(fileName, message, true);
                close();
            }catch(Exception e){
                System.out.println("log entry unsuccessful");

            }
    }

    public static void readReport(String fileName) throws ParentException {
        System.out.println(FileHandler.fileReader(fileName));
    }






//        public static void logError(String message)  {
//        try {
////            if (fileName.equals(""))
////                throw some exception
//            fileWriter(fileName, "{ERROR} : " + message, true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        }



    }





