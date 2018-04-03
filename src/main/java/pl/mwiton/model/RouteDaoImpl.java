package pl.mwiton.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mateusz Witoń on 23.03.2018.
 */
@Repository
public class RouteDaoImpl implements RouteDao {
    @PersistenceContext
    private EntityManager entityManager;

    public RouteDaoImpl() {
    }

    @Override
    @Transactional
    public void save(Route route) {
        entityManager.persist(route);
    }

    @Override
    public Route getRoute(int id) {
        Route route = entityManager.find(Route.class, id);
        return route;
    }

    @Override
    public List<Route> getAllRoutes() {
        return null;
    }
}
