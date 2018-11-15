package Servlet;

import DAO.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserDao users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        for(Cookie c : req.getCookies())
        {
            if(c.getName() == "username")
            {
                req.setAttribute("username", c.getValue());
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        if(users.login(req.getParameter("username"), req.getParameter("password")))
        {
            req.getSession().setAttribute("User", req.getParameter("username"));
            if(req.getParameter("rememberMe") != null && req.getParameter("rememberMe").equals("on")){
                Cookie user = new Cookie("username", req.getParameter("username"));
                user.setMaxAge(60*60*24*30); // 1 month
                resp.addCookie(user);
            }
            else{
                Cookie user = new Cookie("username", null);
                user.setMaxAge(-1);
                resp.addCookie(user);
            }
            resp.sendRedirect("index");
        }
        else
        {
            req.setAttribute("msg", "Failed to Log In!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    public LoginServlet(){
        super();
        users = new UserDao();
    }
}
