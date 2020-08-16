package isabel.centraldeerros.mappers;

import isabel.centraldeerros.dto.EventDTO;
import isabel.centraldeerros.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDTO map(Event event);
    List<EventDTO> map(List<Event> events);
}
