
import java.io.*;
import java.io.FileNotFoundException;
import java.util.HashMap;


public class ReadingUsersFile{

    public static void main(String[] args) {


        HashMap<Movies, Ratings> users = new HashMap<>();

        try
        {
            InputStream is = new FileInputStream(users.dat);
            ObjectInput oi = new ObjectInputStream(is);

            // loop until all lines are read
            while (fileRead != null)
            {


                HashMap<K, V> newMap = oi.readObject();
                oi.close();
}


    /*Write:
    OutputStream os = new FileOutputStream(fileName.ser);
    ObjectOutput oo = new ObjectOutputStream(os);
oo.writeObject(map);
        oo.close();*/

//Read:


