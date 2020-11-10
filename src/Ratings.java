public class Ratings {

    private final String userID;
    private final String movieID;
    private final String ratings;


    public Ratings(String userID, String movieID, String ratings)
    {
        this.userID = userID;
        this.movieID = movieID;
        this.ratings = ratings;
    }


    public String toString() {
        return "User ID: " + userID + "\n" + "Movie ID: " + movieID + "\n"
                + "ratings: " + ratings + "\n";
    }
}
