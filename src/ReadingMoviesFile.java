import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ReadingMoviesFile {


    final static String filePath = "movies.dat";


    public static void main(String[] args) {

        //read text file to HashMap
        Map<Integer, String> mapFromFile = getHashMapFromTextFile();

        //iterate over HashMap entries
        for(Map.Entry<Integer, String> entry : mapFromFile.entrySet()){
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        }
    }

    public static Map<Integer, String> getHashMapFromTextFile(){

        Map<Integer, String> mapFileContents = new HashMap<Integer, String>();
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

                //first part is movieID, second is title
                Integer movieID = Integer.parseInt( parts[0].trim() );
                String title = parts[1].trim();


                //put movieID, tittle in HashMap if they are not empty
                if(  !movieID.equals("") && !title.equals("") )
                    mapFileContents.put(movieID, title);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{

            // close the BufferedReader
            if(br != null){
                try {
                    br.close();
                }catch(Exception e){};
            }
        }

        return mapFileContents;
    }
}