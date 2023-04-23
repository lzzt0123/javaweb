package edu.hit.lizitong.service.impl;

import edu.hit.lizitong.dao.UserDao;
import edu.hit.lizitong.dao.impl.UserDaoImpl;
import edu.hit.lizitong.domain.User;
import edu.hit.lizitong.service.UserSerive;

public class UserSeriveImpl implements UserSerive {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public Boolean regist(User user){
        User ByUsername = userDao.findByUsername(user.getUsername());
        if(ByUsername!=null){
            return false;
        }
        userDao.save(user);
        return true;
    }
    @Override
    public User login(User user){
        User ByUsernameAndPassword = userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());

        return ByUsernameAndPassword;
    }

}
