package isabel.centraldeerros.endpoints;

import isabel.centraldeerros.dto.EventDTO;
import isabel.centraldeerros.entity.Event;
import isabel.centraldeerros.mappers.EventMapper;
import isabel.centraldeerros.service.impl.EventService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private EventMapper mapper;

    @PostMapping
    public Event save(@RequestBody Event event) {
        return  eventService.save(event);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Event>(eventService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found")), HttpStatus.OK);
    }

    @GetMapping
    public Iterable<EventDTO> findAll(
            @And({
                    @Spec(path = "level", spec = Equal.class),
                    @Spec(path = "description", spec = Equal.class),
                    @Spec(path = "log", spec = Equal.class),
                    @Spec(path = "source", spec = Equal.class),
                    @Spec(path = "date", spec = Equal.class),
                    @Spec(path = "quantity", spec = Equal.class)
            }) Specification<Event> eventSpecification,
            Pageable pageable
    ) {
        return mapper.map(this.eventService.findAll(eventSpecification, pageable));
    }
}
