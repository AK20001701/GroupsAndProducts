package groupsAndProducts.servlet;

import groupsAndProducts.dao.jdbcImplementation.JdbcGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    private static final String url = "/WEB-INF/view/test.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JdbcGroupDao jdbcGroupDao = new JdbcGroupDao();
        jdbcGroupDao.getAll().stream().forEach(System.out::println);
        req.getRequestDispatcher(url).forward(req, resp);
    }

}
