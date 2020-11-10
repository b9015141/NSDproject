public class Movies {

    private final String movieID;
    private final String title;

    public Movies(String movieID, String title)
    {
        this.movieID = movieID;
        this.title = title;
    }


    public String toString() {
        return "Movie ID: " + movieID + "\n" + "Title: " + title + "\n";
    }
}