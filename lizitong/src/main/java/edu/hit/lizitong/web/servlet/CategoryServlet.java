package edu.hit.lizitong.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hit.lizitong.domain.Category;
import edu.hit.lizitong.service.CategoryService;
import edu.hit.lizitong.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categroy/*")
public class CategoryServlet extends BaseServlet{
    private CategoryService service = new CategoryServiceImpl();

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> cs = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(),cs);

    }
 }
