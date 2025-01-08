package org.example.repository;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {
    List<T> findAll() throws SQLException;

    T getById(String id) throws SQLException;

    void save(T t);

    void delete(String id);
}
