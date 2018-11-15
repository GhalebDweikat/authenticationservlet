package DAO;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    List<User> users = new ArrayList<User>();

    public UserDao() {
        users.add(new User("Ghaleb", "123"));
        users.add(new User("Amer", "123"));
        users.add(new User("Admin", "Admin"));
    }

    public boolean login(String username, String password)
    {
        for (User u: users
             ) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }
}
