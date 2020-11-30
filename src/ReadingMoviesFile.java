import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadingMoviesFile {


    public static List<Movies> readMovies (File f) {

        List<Movies> movies = new ArrayList<Movies>();

        BufferedReader reader = null;
        String line = null;

        try {
            reader = getFileReader(f);
            while ((line = reader.readLine()) != null) {
                String[] token = parseLine(line);
                int movieID = Integer.parseInt(token[0]);
                String title = token[1];
                movies.add(new Movies(movieID, title));
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } finally {
        }

        return movies;

    }

    private static String[] parseLine (String line){
        // possible field delimiters: "::", "\t", "|"
        return line.split("::|\t|\\|");
    }

    private static BufferedReader getFileReader (File f) throws FileNotFoundException {
        return new BufferedReader(new FileReader(f));

    }

    public void moviesList(Map<Integer, String> moviesData){

        for (Integer i : moviesData.keySet())
        {
            System.out.println("Movie ID " + i + "Title " + moviesData.get(i));
        }
    }
}