package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if(req.getSession().getAttribute("User") == "" || req.getSession().getAttribute("User") == null)
//            req.getRequestDispatcher("login.jsp").forward(req, resp);
//        else {
            req.setAttribute("User", req.getSession().getAttribute("User"));
            req.getRequestDispatcher("index.jsp").forward(req, resp);
//        }
    }
}
