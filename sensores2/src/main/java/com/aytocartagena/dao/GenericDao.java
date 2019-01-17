package com.aytocartagena.dao;
import java.util.List;

/**
 *  
 * @param <E>
 * @param <K>
 */
public interface GenericDao<E,K> {
    public void add(E entity) ;
    public void saveOrUpdate(E entity) ;
    public void update(E entity) ;
    public void remove(E entity);
    public E find(K key);
    public List<E> getAll() ;
    public List<E> getAllOfType(Class<? extends E> concretedaoType);
}