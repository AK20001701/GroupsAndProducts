package groupsAndProducts.service;

import groupsAndProducts.dao.GroupDao;
import groupsAndProducts.dao.jdbcImplementation.JdbcGroupDao;
import groupsAndProducts.domain.Group;

import java.util.List;

public class GroupService {
    private final GroupDao groupDao;

    public GroupService() {
        this.groupDao = new JdbcGroupDao();
    }

    public Group getById(Long id) {
        return groupDao.get(id);
    }

    public List<Group> getAll() {
        return groupDao.getAll();
    }

    public Long getProductsCountById(Long id){
        return groupDao.getProductsCountById(id);
    }

}
