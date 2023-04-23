package edu.hit.lizitong.dao;

import edu.hit.lizitong.domain.User;

public interface UserDao {

    User findByUsername(String username);
    public void save(User user);

    User findByUsernameAndPassword(String username, String password);
}
