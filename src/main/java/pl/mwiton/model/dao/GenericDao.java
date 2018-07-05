package pl.mwiton.model.dao;

import org.springframework.data.util.TypeDiscoverer;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Mateusz Witoń on 08.04.2018.
 */

@Transactional
public abstract class GenericDao<T, K> {
    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> type;

    @SuppressWarnings("unchecked")
    GenericDao() {
        type = (Class<T>) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];

    }
}
