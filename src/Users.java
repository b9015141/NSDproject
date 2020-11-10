public class Users {

//private instance variables
   private final String userID;


//Constructs Users instance with the given inputs
   public Users(String userID)
   {
      this.userID = userID;
   }

   //public getters ans setters for the the private instance variables
   //No setters for the variables that are not designed to be changed.
   //returns the UserID
   public String getUserID(){
      return userID;
   }


   public String toString() {
      return "User ID: " + userID + "\n";

   }
}
