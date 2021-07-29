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


    public List<Group> getPage(Integer page) {
        return groupDao.getPage(page);
    }

    public Long getProductsCountById(Long id){
        return groupDao.getProductsCountById(id);
    }

}
