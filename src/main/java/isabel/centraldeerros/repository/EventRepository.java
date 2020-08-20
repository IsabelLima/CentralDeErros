package isabel.centraldeerros.repository;

import isabel.centraldeerros.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;


public interface EventRepository extends CrudRepository<Event, Long>, JpaSpecificationExecutor {

    Page<Event> findAll(Specification specification, Pageable pageable);
}
