package pl.mwiton.transportbooking.respositories;

import org.springframework.data.repository.CrudRepository;
import pl.mwiton.transportbooking.model.stop.Stop;

public interface StopRepository extends CrudRepository<Stop, Long> {
}
