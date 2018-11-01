package pl.mwiton.transportbooking.respositories;

import org.springframework.data.repository.CrudRepository;
import pl.mwiton.transportbooking.model.line.Line;

public interface LineRepository extends CrudRepository<Line, Long> {
}
