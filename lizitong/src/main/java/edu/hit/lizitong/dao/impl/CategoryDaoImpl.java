package edu.hit.lizitong.dao.impl;

import edu.hit.lizitong.dao.CategoryDao;
import edu.hit.lizitong.domain.Category;
import edu.hit.lizitong.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll(){
        String sql = "select * from tab_category";
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));

    }
}
