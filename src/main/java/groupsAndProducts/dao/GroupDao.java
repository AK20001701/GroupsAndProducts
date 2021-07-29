package groupsAndProducts.dao;

import groupsAndProducts.domain.Group;

import java.util.List;

public interface GroupDao{
    Long getProductsCountById(Long id);

    List<Group> getPage(Integer page);
}
