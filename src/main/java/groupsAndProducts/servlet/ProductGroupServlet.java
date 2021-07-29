package groupsAndProducts.servlet;

import groupsAndProducts.dao.jdbcImplementation.JdbcGroupDao;
import groupsAndProducts.domain.Group;
import groupsAndProducts.service.GroupService;
import groupsAndProducts.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@WebServlet("/")
public class ProductGroupServlet  extends HttpServlet {
    private static final String url = "/WEB-INF/view/groupProduct.jsp";

    private final GroupService groupService = new GroupService();
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Group, Long> groupElementCount = new TreeMap<>(
                groupService.getAll().stream().collect(Collectors.toMap(e -> e, e ->groupService.getProductsCountById(e.getId())))
        );
        req.setAttribute("groupElementCount", groupElementCount);

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("GROUP_ID"));

        Map<Group, Long> groupElementCount = new TreeMap<>(
                groupService.getAll().stream().collect(Collectors.toMap(e -> e, e ->groupService.getProductsCountById(e.getId())))
        );
        req.setAttribute("groupElementCount", groupElementCount);

        req.setAttribute("products", productService.getAllProductsInGroupByGroupId(id));
        req.getRequestDispatcher(url).forward(req, resp);
    }
}
