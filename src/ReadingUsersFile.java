import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;


public class ReadingUsersFile {


    public static List<Users> readUsers (File f) {

        List<Users> users = new ArrayList<Users>();

        BufferedReader reader = null;
        String line = null;

        try {
            reader = getFileReader(f);
            while ((line = reader.readLine()) != null) {
                String[] token = parseLine(line);
                int userID = Integer.parseInt(token[0]);
                users.add(new Users(userID));
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } finally {
        }

        return users;

    }

    private static String[] parseLine (String line){
        // possible field delimiters: "::", "\t", "|"
        return line.split("::|\t|\\|");
    }

    private static BufferedReader getFileReader (File f) throws FileNotFoundException {
        return new BufferedReader(new FileReader(f));

    }

    public void usersList(Map<Integer, Integer> usersData) {

        for (Integer i : usersData.keySet()) {
            System.out.println("User ID " + i + usersData.get(i));
        }
    }
}