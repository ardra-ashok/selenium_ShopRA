package Handler;


import Exceptions.APIOException;
import Exceptions.ParentException;

import java.io.*;



public class FileHandler {
        private static BufferedWriter bw;
        private static BufferedReader br;
        private static FileReader fr;
        private static FileWriter file;

    public static void fileWriter(String fileName, String toWrite, Boolean append) throws ParentException    {
        try {

            file = new FileWriter(fileName, append);

            bw = new BufferedWriter(file);
            bw.write(toWrite);
            bw.newLine();
        }catch(IOException e){
            System.out.println("Error writing to file not successful");
            throw new  APIOException("Error writing to file not successful",e);
        }

    }



    // write exception
  public static void close() throws ParentException {
       try {
           bw.close();
           file.close();
        } catch (IOException e) {
           System.out.println("error closing the buffered writer");
         //   throw new APIOException("error closing the buffered writer",e);
       }
    }



    public static String fileReader(String filepath) throws ParentException {
        try{
            String line;
            File file = new File(filepath);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            return sb.toString();

        }catch(IOException e){
            return "Error Occurred while file reading";
        //    throw new APIOException("Error Occurred while file reading",e);
        }

    }
}
