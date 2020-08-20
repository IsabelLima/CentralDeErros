package isabel.centraldeerros.service.impl;

import isabel.centraldeerros.entity.Event;
import isabel.centraldeerros.repository.EventRepository;
import isabel.centraldeerros.service.interfaces.EventServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService implements EventServiceInterface {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> findAll(Specification<Event> eventSpecification, Pageable pageable) {
        return eventRepository.findAll(eventSpecification, pageable).getContent();
    }
}
