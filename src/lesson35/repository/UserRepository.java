package lesson35.repository;

import lesson35.model.User;
import lesson35.model.UserType;

import java.io.*;
import java.util.ArrayList;

public class UserRepository {
    private String path = "/home/anton/UserDB.txt";
    //read data - read file
    //work with data - mapping data
    public ArrayList<User> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            ArrayList<User> users = new ArrayList<>();
            String[] array;
            String line;
            while ((line = br.readLine()) != null) {
                array = line.split(",");
                User user = new User();
                users.add(user.fromStringToObject(array));
            }
            return users;
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
        return null;
    }

    public User registerUser(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append("\n");
            bufferedWriter.append(user.toString());
            return user;
        } catch (IOException e) {
            System.err.println("Can't write to file" + path);
        }
        return null;
    }
}
