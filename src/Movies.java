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

    private int getMovieID(){
        return this.movieID;
    }

    private String getTitle(){
        return this.title;
    }

    public void addRating(Ratings mr) {
        this.moviesRatings.add(mr);
    }

    public List<Ratings> getMoviesRatings(){
        return this.moviesRatings;
    }
}