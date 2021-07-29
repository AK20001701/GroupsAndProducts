package groupsAndProducts.servlet;

import groupsAndProducts.dao.jdbcImplementation.JdbcGroupDao;
import groupsAndProducts.domain.Group;
import groupsAndProducts.domain.Product;
import groupsAndProducts.service.GroupService;
import groupsAndProducts.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@WebServlet("/")
public class ProductGroupServlet extends HttpServlet {
    private static final String url = "/WEB-INF/view/groupProduct.jsp";

    private final GroupService groupService = new GroupService();
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int groupPage = 1;
        int productPage = 1;
        long groupId = 0;
        int sortByPrice = -1;
        int sortByName = -1;

        if (req.getParameter("sortByPrice") != null) {
            sortByPrice = Integer.parseInt(req.getParameter("sortByPrice"));
        }
        if (req.getParameter("sortByName") != null) {
            sortByName = Integer.parseInt(req.getParameter("sortByName"));
        }

        if (req.getParameter("groupPage") != null) {
            groupPage = Integer.parseInt(req.getParameter("groupPage"));
        }

        if (req.getParameter("productPage") != null) {
            productPage = Integer.parseInt(req.getParameter("productPage"));
        }
        if (req.getParameter("groupId") != null) {
            groupId = Integer.parseInt(req.getParameter("groupId"));
        }

        Map<Group, Long> groupElementCount = new TreeMap<>(
                groupService.getAll().stream().collect(Collectors.toMap(e -> e, e -> groupService.getProductsCountById(e.getId())))
        );
        req.setAttribute("groupElementCount", groupElementCount);
        req.setAttribute("groupId", groupId);
        req.setAttribute("groupPage", groupPage);
        req.setAttribute("productPage", productPage);
        req.setAttribute("sortByPrice", sortByPrice);
        req.setAttribute("sortByName", sortByName);

        List<Product> productList = productService.getAllProductsInGroupByGroupId(groupId, productPage);

        if (sortByName == 0) {
            productList = productList.stream().sorted(Comparator.comparing(Product::getProductName)).collect(Collectors.toList());
        }

        if (sortByName == 1) {
            productList = productList.stream().sorted((p1, p2) -> p2.getProductName().compareTo(p1.getProductName())).collect(Collectors.toList());
        }

        if (sortByPrice == 0) {
            productList = productList.stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
        }

        if (sortByPrice == 1) {
            productList = productList.stream().sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice())).collect(Collectors.toList());
        }

        req.setAttribute("products", productList);


        req.getRequestDispatcher(url).forward(req, resp);
    }


}
