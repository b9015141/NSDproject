import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadingRatingsFile {

    // public static void main(String[] args) {

    public static List<Ratings> readRatings (File f){

        List<Ratings> ratings = new ArrayList<Ratings>();

        BufferedReader reader = null;
        String line = null;
        try {
            reader = getFileReader(f);
            while ((line = reader.readLine()) != null) {
                String[] token = parseLine(line);
                int userId = Integer.parseInt(token[0]);
                int movieId = Integer.parseInt(token[1]);
                int rating = Integer.parseInt(token[2]);
                ratings.add(new Ratings(userId, movieId, rating));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();

        } finally {
        }

        return ratings;

    }

    private static String[] parseLine (String line){
        // possible field delimiters: "::", "\t", "|"
        return line.split("::|\t|\\|");
    }

    private static BufferedReader getFileReader (File f) throws FileNotFoundException {
        return new BufferedReader(new FileReader(f));

    }


}













