package app.dao;

import app.model.User;
import java.util.List;


public interface DaoUser {

    public User getUser(int id);

    List<User> getUsers();

    public void saveUser(User user);

    public void deleteUser(int id);
}


