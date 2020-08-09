package isabel.centraldeerros.endpoints;

import isabel.centraldeerros.entity.Event;
import isabel.centraldeerros.service.impl.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public  Event save(@RequestBody Event event) {
        return  eventService.save(event);
    }


}
