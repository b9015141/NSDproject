public class Ratings {

    private final int userID;
    private final int movieID;
    private final int ratings;


    public Ratings(int userID, int movieID, int ratings){
        this.userID = userID;
        this.movieID = movieID;
        this.ratings = ratings;
    }



    public int getUserID(){
        return this.userID;
    }

    public int getMovieID(){
        return this.movieID;
    }

    public int getRatings(){
        return this.ratings;
    }


    //toString (overridden) method to show data of the file
    @Override
    public String toString() {
        return  "UserID: " + this.getUserID() + "\n" + "MovieID: " + this.movieID + "\n" + "Rating: " + this.ratings;
    }
}

