package service;

import menue.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    public void saveUser(User user) throws IOException, ClassNotFoundException;
    public List<User> getUsers();
    boolean checkUser(User user);
}
