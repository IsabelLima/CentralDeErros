package isabel.centraldeerros.service.impl;

import isabel.centraldeerros.repository.EventRepository;
import isabel.centraldeerros.service.interfaces.EventServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService implements EventServiceInterface {

    @Autowired
    private EventRepository eventRepository;
}