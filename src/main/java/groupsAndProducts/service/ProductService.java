package groupsAndProducts.service;

import groupsAndProducts.dao.ProductDao;
import groupsAndProducts.dao.jdbcImplementation.JdbcProductDao;
import groupsAndProducts.domain.Product;

import java.util.List;

public class ProductService {
    private final ProductDao productDao;

    public ProductService() {
        this.productDao = new JdbcProductDao();
    }

    public List<Product> getAllProductsInGroupByGroupId(Long id, Integer page) {
        return productDao.getAllProductsInGroupByGroupId(id, page);
    }
}
