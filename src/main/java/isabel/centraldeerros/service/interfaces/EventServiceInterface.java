package isabel.centraldeerros.service.interfaces;

import isabel.centraldeerros.entity.Event;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventServiceInterface {
    public Event save(Event event);
    public Optional<Event> findById(Long id);
    public List<Event> findAll(Pageable pageable);
}


