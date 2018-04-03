package pl.mwiton.model;

import java.util.List;

/**
 * Created by Mateusz Witoń on 23.03.2018.
 */
public interface RouteDao {
    void save(Route route);
    Route getRoute(int id);
    List<Route> getAllRoutes();
}
