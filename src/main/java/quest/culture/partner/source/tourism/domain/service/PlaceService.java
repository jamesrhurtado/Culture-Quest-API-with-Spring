package quest.culture.partner.source.tourism.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import quest.culture.partner.source.tourism.domain.model.entity.Place;

import java.util.List;

public interface PlaceService {
/*    List<Place> getAll();
    List<Place> getAllByDestinationId(Long destinationId);
    Page<Place> getAllByDestinationId(Long destinationId, Pageable pageable);*/
    Place create(Long destinationId, Place place);
    Place getByPlaceId(Long placeId);
    Place update(Long destinationId, Long placeId, Place place);
    //ResponseEntity<?> delete(Long destinationId, Long placeId);
}
