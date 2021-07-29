package groupsAndProducts.dao;

import groupsAndProducts.domain.Group;

public interface GroupDao extends Dao<Group>{
    Long getProductsCountById(Long id);
}
