import java.util.ArrayList;
import java.util.List;

public class Users {

   public int userID;
   private List<Ratings> ratingsByUser;


   //Constructs Users instance with the given inputs
   public Users(int userID) {
      this.userID = userID;
      this.ratingsByUser = new ArrayList<>();
   }



   //public getters ans setters for the the private instance variables
   //No setters for the variables that are not designed to be changed.
   //returns the UserID
   public int getUserID(){
      return userID;
   }

   public void addRating(Ratings mr) {
      this.ratingsByUser.add(mr);
   }

  public List<Ratings> getUsersRatings(){
      return this.ratingsByUser;
  }
}
