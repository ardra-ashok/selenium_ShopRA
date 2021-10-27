package Handler;

import Exceptions.APIOException;
import Exceptions.ParentException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler {
    public static void fileWriter(String fileName,String toWrite) throws ParentException {

    try{
        //File file = new File(dateFormat.format(date) + "") ;
        File fl =  File.createTempFile(fileName+ "-", ".txt", new File("C:\\Users\\61491\\intellij\\ShoppingProjectMave\\tempfiles"));


        FileWriter fw = new FileWriter(fl);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toWrite);
        bw.close();
        fw.close();


    }catch (IOException e){

        e.printStackTrace();
    }


    }
    public static void fileReader(String filepath) throws ParentException {
        try {
            String line;
            File file = new File(filepath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
