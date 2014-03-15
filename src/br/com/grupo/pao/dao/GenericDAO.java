package br.com.grupo.pao.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
    
    Class<T> getEntityClass();
    
    T findById(final ID id);

    List<T> findAllWithNamedQuery(final String name);

    /*List<T> findByExample(final T exampleInstance);

    List<T> findByNamedQuery(
        final String queryName,
        Object... params
    );

    List<T> findByNamedQueryAndNamedParams(
        final String queryName,
        final Map<String, ?extends Object> params
    );*/

    //Long countAll();

    //Long countByExample(final T exampleInstance);

    
    T save(final T entity);
    
    T update(final T entity);

    void delete(final T entity);
}