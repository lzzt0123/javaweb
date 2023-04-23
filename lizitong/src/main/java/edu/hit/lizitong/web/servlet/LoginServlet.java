package edu.hit.lizitong.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hit.lizitong.domain.ResultInfo;
import edu.hit.lizitong.domain.User;
import edu.hit.lizitong.service.UserSerive;
import edu.hit.lizitong.service.impl.UserSeriveImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理数据
        Map<String,String[]> parameterMap= req.getParameterMap();
        //封装user函数
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        //service完成登录
        UserSerive userSerive = new UserSeriveImpl();
        User u = userSerive.login(user);
        ResultInfo info = new ResultInfo();
        //响应结果
        if(u==null){
            //注册成功
            info.setFlag(false);
            info.setErrorMsg("用户名或者密码错误！");
        }else {
            info.setFlag(true);
            req.getSession().setAttribute("user",u);
        }
        //将info序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        resp.setContentType("application/json;charset=utf-8");

        //将json写到客户端
        resp.getWriter().write(json);
    }
}
