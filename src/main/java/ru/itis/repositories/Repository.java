package ru.itis.repositories;

public interface Repository<T, V> {
    void save(T t) throws Exception;
}