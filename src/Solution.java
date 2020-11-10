
        import java.io.*;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.List;

public class Solution {

    public static void main(String[] args) {


        List<Movies> moviesArray = new ArrayList<>();
        try
        {
            // create a Buffered Reader object instance with a FileReader
            BufferedReader brMovie = new BufferedReader(new FileReader("movies.dat"));

            // read the first line from the text file
            String fileRead = brMovie.readLine();

            // loop until all lines are read
            while (fileRead != null)
            {

                // use string.split to load a string array with the values from each line of
                // the file, using a comma as the delimiter
                String[] tokenize = fileRead.split("\\|");

                //assume file is made correctly
                // and make temporary variables for the three types of data
                String tempMovieID = tokenize[0];
                String tempTitle = tokenize[1];

                // create temporary instance of Inventory object
                // and load with three data values
                Movies Movie = new Movies(tempMovieID, tempTitle);

                // add to array list
                moviesArray.add(Movie);

                // read next line before looping
                // if end of file reached
                fileRead = brMovie.readLine();
            }

            // close file stream
            brMovie.close();
        }

        // handle exceptions
        catch (FileNotFoundException fileNotFound)
        {
            System.out.println("file not found");
        }

        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        // display movies
        for (Movies each : moviesArray)
        {
            System.out.println("====================");
            System.out.println(each);
            System.out.println();

        }

    }
}
