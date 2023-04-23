package edu.hit.lizitong.service;

import edu.hit.lizitong.domain.User;

public interface UserSerive {
    Boolean regist(User user);

    User login(User user);
}
