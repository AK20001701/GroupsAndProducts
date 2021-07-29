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

    public Group getById(long id) {
        return groupDao.get(id);
    }

    public List<Group> getAll() {
        return groupDao.getAll();
    }

}
