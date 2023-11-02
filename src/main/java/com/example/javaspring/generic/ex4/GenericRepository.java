package com.example.javaspring.generic.ex4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericRepository<E extends Entity<K>, K> {

    Map<K, E> datasource = new HashMap<>();

    public void save(E e) {
        datasource.put(e.getId(), e);
    }

    public void delete(E e) {
        datasource.remove(e.getId());
    }

    public void delete(K k) {
        datasource.remove(k);
    }

    public List<E> findAll() {
        return new ArrayList<>(datasource.values());
    }

    public E findById(K id) {
        return datasource.get(id);
    }
}
