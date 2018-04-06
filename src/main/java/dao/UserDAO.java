package dao;

import entities.User;

public interface UserDAO {

    User find(String email, String password);
    boolean exists(String email);
    int save(User user);
}
