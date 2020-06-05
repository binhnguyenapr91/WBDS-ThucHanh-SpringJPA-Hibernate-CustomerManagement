package repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T getById(Long id);
    void save(T model);
    void remove (Long id);
}
