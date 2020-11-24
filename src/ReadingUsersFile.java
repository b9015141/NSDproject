import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReadingUsersFile {

    final static String filePath = "users.dat";

    public static void main(String[] args) {

        //read text file to HashMap
        Map<Integer, Integer> mapFromFile = getHashMapFromTextFile();

        //iterate over HashMap entries
        for(Map.Entry<Integer, Integer> entry : mapFromFile.entrySet()){
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        }
    }

    public static Map<Integer, Integer> getHashMapFromTextFile(){

        Map<Integer, Integer> mapFileContents = new HashMap<Integer, Integer>();
        BufferedReader br = null;

        try{

            //create file object
            File file = new File(filePath);

            //create BufferedReader object from the File
            br = new BufferedReader( new FileReader(file) );

            String line = null;

            //read file line by line
            while ( (line = br.readLine()) != null ){

                //split the line by :
                String[] parts = line.split("\\|");

                //first part is name, second is ratings
                Integer userID = Integer.parseInt( parts[0].trim() );
                Integer userRatings = Integer.parseInt( parts[4].trim() );


                //put name, ratings in HashMap if they are not empty
                if(  !userID.equals("") && !userRatings.equals("") )
                    mapFileContents.put(userID, userRatings);
            }

        } catch(NumberFormatException ex){
            System.err.println("Invalid string in argument");
            //request for well-formatted string


        } catch(Exception e) {
            e.printStackTrace();
        } finally{

            //close the BufferedReader
            if(br != null){
                try {
                    br.close();
                }catch(Exception e){};

            }
        }

        return mapFileContents;

    }
}