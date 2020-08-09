package isabel.centraldeerros.service.interfaces;

import isabel.centraldeerros.entity.Event;

import java.util.Optional;

public interface EventServiceInterface {
    public Event save(Event event);
    public Optional<Event> findById(Long id);
}

