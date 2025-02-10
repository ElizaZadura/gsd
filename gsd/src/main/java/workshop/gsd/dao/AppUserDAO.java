package workshop.gsd.dao;

import java.util.Collection;

public interface AppUserDAO<T> {
    T persist(T appUser);

    T findByUsername(String username);

    Collection<T> findAll();

    boolean remove(int id);

}
