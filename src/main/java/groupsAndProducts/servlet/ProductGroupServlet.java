package groupsAndProducts.servlet;

import groupsAndProducts.dao.jdbcImplementation.JdbcGroupDao;
import groupsAndProducts.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class ProductGroupServlet  extends HttpServlet {
    private static final String url = "/WEB-INF/view/groupProduct.jsp";

    private GroupService groupService = new GroupService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        JdbcGroupDao jdbcGroupDao = new JdbcGroupDao();
//        jdbcGroupDao.getAll().stream().forEach(System.out::println);
//
//
//        req.setAttribute("children", groupService.getAll());



        req.getRequestDispatcher(url).forward(req, resp);
    }
}
