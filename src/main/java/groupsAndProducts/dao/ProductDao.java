package groupsAndProducts.dao;

import groupsAndProducts.domain.Product;

import java.util.List;

public interface ProductDao{
    List<Product> getAllProductsInGroupByGroupId(Long id, Integer page);
}
