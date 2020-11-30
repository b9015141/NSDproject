import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;
        //Declaring instances of classes
        ReadingRatingsFile readRatingsFile = new ReadingRatingsFile();
        ReadingUsersFile readUsersFile = new ReadingUsersFile();
        ReadingMoviesFile readMoviesFile = new ReadingMoviesFile();

        //Read Files
        List<Ratings> ratings;
        List<Movies> movies;
        List<Users> users;


        while (choice != 7) {

            System.out.println("------------- Please choose an option ------------------ " + "\n");
            System.out.println("1. Display ratings: ");
            System.out.println("2. Display movies: ");
            System.out.println("3. Display users: ");
            System.out.println("4. Display average ratings given by each user: ");
            System.out.println("5. Display average ratings given to each movie: ");
            System.out.println("6. Compare 2 users: ");
            System.out.println("7. Exit ");

            choice = input.nextInt();

            switch (choice) {
                case 1: {

                    ratings = readRatingsFile.readRatings(new File("ratings.dat"));


                    for (Ratings rating : ratings) {
                        System.out.println(rating.toString());
                        System.out.println("====================");
                    }

                    break;
                }

                case 2: {
                    movies = readMoviesFile.readMovies(new File("movies.dat"));

                    for (Movies movieList : movies) {
                        System.out.println(movieList.toString());
                        System.out.println("====================");
                    }
                    break;
                }

                case 3: {
                    users = readUsersFile.readUsers(new File("users.dat"));

                    for (Users userList : users) {
                        System.out.println(userList.toString());
                        System.out.println("====================");
                    }
                    break;
                }

                case 4: {
                    List listRatingMovie = new ArrayList<>();
                    int searchUserID = 0;
                    double sumAverage = 0;
                    int numRatings = 0;

                    Scanner reader = new Scanner(System.in);
                    System.out.print("Enter UserID: ");
                    searchUserID = reader.nextInt();

                    ratings = readRatingsFile.readRatings(new File("ratings.dat"));


                    for (Ratings rating : ratings) {
                        if (rating.getUserID() == searchUserID) {
                            // listRatingMovie.add(rating.getRatings());
                            sumAverage = sumAverage + rating.getRatings();
                            numRatings++;
                        }
                    }
                    System.out.println("Average Ratings: " + sumAverage / numRatings + "\n");

                    break;

                }

                case 5: {

                    //List listRatingMovie = new ArrayList<>();
                    int searchMovieID = 0;
                    double sumaMedia = 0;
                    int numVotos = 0;
                    String movieTitle = " ";

                    Scanner reader = new Scanner(System.in);
                    System.out.print("Enter MovieID: ");
                    searchMovieID = reader.nextInt();


                    ratings = readRatingsFile.readRatings(new File("ratings.dat"));
                    movies = readMoviesFile.readMovies(new File("movies.dat"));


                    for (Ratings rating : ratings) {
                        if (rating.getMovieID() == searchMovieID) {
                            // listRatingMovie.add(rating.getRatings());
                            sumaMedia = sumaMedia + rating.getRatings();
                            numVotos++;
                        }
                    }

                    for (Movies movie : movies) {
                        if (movie.getMovieID() == searchMovieID) {
                            movieTitle = movie.getTitle();
                        }
                    }

                    System.out.println("\n Title: " + movieTitle + "\n Average Ratings: " + sumaMedia / numVotos + "\n");
                    break;

                }

                case 6: {

                    int firstUserID = 0;
                    int secondUserID = 0;
                    String movieTitle = " ";
                    boolean noCommonMovies = false;

                    Scanner reader = new Scanner(System.in);
                    System.out.print("Enter 1st UserID: ");
                    firstUserID = reader.nextInt();

                    System.out.print("Enter 2nd UserID: ");
                    secondUserID = reader.nextInt();

                    ratings = readRatingsFile.readRatings(new File("ratings.dat"));
                    movies = readMoviesFile.readMovies(new File("movies.dat"));

                    //LIST THAT STORES MOVIE ID FOR EACH USER
                    List<Integer> ratingsUser1 = new ArrayList<Integer>();
                    List<Integer> ratingsUser2 = new ArrayList<Integer>();

                    for (Ratings rating : ratings) {
                        if (rating.getUserID() == firstUserID) {
                            ratingsUser1.add(rating.getMovieID());
                        }

                        if (rating.getUserID() == secondUserID) {
                            ratingsUser2.add(rating.getMovieID());
                        }
                    }


                    //removes all duplicates non-duplicates from ratingsUser1. so it now contains all the moviesIds that are
                    //shared by both
                    ratingsUser1.retainAll(ratingsUser2);

                    //loop through the array that holds all the shared movie ids
                    for (Integer rating1 : ratingsUser1) {
                        System.out.println(rating1);
                        for (Movies movieList : movies) {
                            //if statement that compares
                            if (rating1 == movieList.movieID) {
                                movieTitle = movieList.getTitle();
                                System.out.println("\n User1: " + firstUserID + " \n User2: " + secondUserID + " \n have " + movieTitle + " in common");
                            }

                        }

                    }
                }

                case 7: {
                    System.exit(0);
                }
            }
        }
    }
}



