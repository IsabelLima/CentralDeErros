package isabel.centraldeerros.endpoints;

import isabel.centraldeerros.entity.Event;
import isabel.centraldeerros.service.impl.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event save(@RequestBody Event event) {
        return  eventService.save(event);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Event>(eventService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found")), HttpStatus.OK);
    }
}
