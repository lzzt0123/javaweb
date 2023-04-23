package edu.hit.lizitong.dao.impl;

import edu.hit.lizitong.dao.UserDao;
import edu.hit.lizitong.domain.User;
import edu.hit.lizitong.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        String sql = "select * from tab_user where username=?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {

        }
        return user;
    }
    @Override
    public void save(User user){
        String sql = "insert into tab_user (username,password,name,birthday,sex,telephone,email) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail());
    }
    @Override
    public User findByUsernameAndPassword(String username, String password){
        String sql = "select * from tab_user where username=? and password=?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        } catch (Exception e) {

        }
        return user;
    }
}
