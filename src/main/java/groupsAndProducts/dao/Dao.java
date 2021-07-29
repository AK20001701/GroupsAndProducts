package groupsAndProducts.dao;

import java.util.List;

public interface Dao<T> {
    T get(long id);

    List<T> getAll();
}
