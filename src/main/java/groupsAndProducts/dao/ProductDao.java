package groupsAndProducts.dao;

import groupsAndProducts.domain.Product;

import java.util.List;

public interface ProductDao extends Dao<Product>{
    List<Product> getAllProductsInGroupByGroupId(Long id, Integer page);
}
