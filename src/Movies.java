
import java.util.ArrayList;
import java.util.List;


public class Movies {

    public final int movieID;
    public final String title;
    private final List<Ratings> moviesRatings;


    public Movies(int movieID, String title) {
        this.movieID = movieID;
        this.title = title;
        this.moviesRatings = new ArrayList<>();
    }

    public int getMovieID(){
        return this.movieID;
    }

    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString() {
        return "MovieID: " + this.getMovieID() + "\n" + "Title: " + this.getTitle();
    }

}
