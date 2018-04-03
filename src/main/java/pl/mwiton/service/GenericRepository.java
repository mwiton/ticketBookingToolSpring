package pl.mwiton.service;

/**
 * Created by Mateusz Witoń on 07.03.2018.
 */
public interface GenericRepository<K,T> {
    T get(K id);
    K add(T object);
}
