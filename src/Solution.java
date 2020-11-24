import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) {


        System.out.println("Select and option: " + "\n");
        System.out.println("------------- Please choose an option ------------------ " + "\n");
        System.out.println("1. Display ratings: " + "\n");
        System.out.println("2. Display movies: " + "\n");
        System.out.println("3. Display users : " + "\n");
        System.out.println("4. Display average ratings given by each user : " + "\n");
        System.out.println("5. Display average ratings given to each movie: " + "\n");
        System.out.println("6. Compare 2 users: " + "\n");


        Scanner input = new Scanner(System.in);

        int choice = input.nextInt();

        switch (choice) {
            case 1: {
                ReadingRatingsFile read = new ReadingRatingsFile();
                read.readRatings(new File("ratings.dat"));
                break;
            }

            case 2: {
                ReadingUsersFile read = new ReadingUsersFile();
                read.getHashMapFromTextFile();
                break;
            }

            case 3: {
                ReadingMoviesFile read = new ReadingMoviesFile();
                read.getHashMapFromTextFile();
                break;
            }
            case 4: {

                break;
            }
            case 5: {
                System.out.println("Choose a MovieID: ");

                int searchMovieID = 0;

                Scanner reader = new Scanner(System.in);
                searchMovieID = reader.nextInt();

                ReadingRatingsFile read = new ReadingRatingsFile();
                read.readRatings(new File("ratings.dat"));

                break;
            }

        }
    }
    }





