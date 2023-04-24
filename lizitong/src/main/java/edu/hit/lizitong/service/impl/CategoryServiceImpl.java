package edu.hit.lizitong.service.impl;

import edu.hit.lizitong.dao.CategoryDao;
import edu.hit.lizitong.dao.impl.CategoryDaoImpl;
import edu.hit.lizitong.domain.Category;
import edu.hit.lizitong.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryDao.findAll();
        return categoryList;
    }
}
