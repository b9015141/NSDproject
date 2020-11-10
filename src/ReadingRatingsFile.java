
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ReadingRatingsFile{

    public static void main(String[] args) {


        List<Ratings> ratingsArray = new ArrayList<>();
        try
        {
            // create a Buffered Reader object instance with a FileReader
            BufferedReader brRating = new BufferedReader(new FileReader("ratings.dat"));

            // read the first line from the text file
            String fileRead = brRating.readLine();

            // loop until all lines are read
            while (fileRead != null)
            {

                // use string.split to load a string array with the values from each line of
                // the file, using a comma as the delimiter
                String[] tokenize = fileRead.split(" ");

                //assume file is made correctly
                // and make temporary variables for the three types of data
                String tempUserID = tokenize[0];
                String tempMovieID = tokenize[0];
                String tempRatings = tokenize[0];


                // create temporary instance of Inventory object
                // and load with three data values
                Ratings Rating = new Ratings(tempUserID, tempMovieID, tempRatings);

                // add to array list
                ratingsArray.add(Rating);

                // read next line before looping
                // if end of file reached
                fileRead = brRating.readLine();
            }

            // close file stream
            brRating.close();
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
        for (Ratings each : ratingsArray)
        {
            System.out.println("====================");
            System.out.println(each);
            System.out.println();

        }

    }
}

