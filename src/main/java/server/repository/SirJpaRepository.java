package server.repository;

import server.exception.SirJpaAddException;

import java.util.List;

public interface SirJpaRepository<K, T> {

    void add(K key, T object) throws SirJpaAddException;
    List<T> getAll() throws Exception;
    T getById(K key) throws Exception;
    void update(K key, T value) throws Exception;
    void delete(K key) throws Exception;

}
