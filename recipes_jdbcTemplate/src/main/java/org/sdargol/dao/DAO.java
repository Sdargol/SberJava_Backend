package org.sdargol.dao;

import java.util.List;

public interface DAO<T> {
    void create(T entity);
    List<T> search(String name);
    T searchFullName(String name);
    void delete(int id);
}
