package edu.hit.lizitong.web.servlet;

import edu.hit.lizitong.domain.PageBean;
import edu.hit.lizitong.domain.Route;
import edu.hit.lizitong.service.RouteService;
import edu.hit.lizitong.service.impl.RouteServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet{

    private RouteService routeService = new RouteServiceImpl();
    public void pageQuery(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //1.接受参数
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");
        String cidStr = req.getParameter("cid");
        int cid = 0;//类别id
        //2.处理参数
        if (cidStr != null && cidStr.length() > 0) {
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int pageSize = 0;//每页显示条数，如果不传递，默认每页显示5条记录
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }
        //3. 调用service查询PageBean对象
        PageBean<Route> pb = routeService.pageQuery(cid, currentPage, pageSize);
        //4. 将pageBean对象序列化为json，返回

        writeJsonValue(resp, pb);


    }
}
