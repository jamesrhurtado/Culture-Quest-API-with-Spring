package quest.culture.partner.source.tourism.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import quest.culture.partner.source.tourism.domain.model.entity.Destination;

import java.util.List;

public interface DestinationService {
    List<Destination> getAll();
    Page<Destination> getAll(Pageable pageable);
    Destination getById(Long destinationId);
    Destination create(Destination destination);
    Destination update(Long id, Destination destination);
    ResponseEntity<?> delete(Long destinationId);
}
