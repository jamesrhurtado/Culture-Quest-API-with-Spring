package quest.culture.partner.source.tourism.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quest.culture.partner.source.tourism.domain.model.entity.Destination;
import quest.culture.partner.source.tourism.domain.model.entity.Place;
import quest.culture.partner.source.tourism.domain.model.enums.HeritageFactor;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByName(String name);
    Optional<Place> findByAltitude(Long altitude);
    Optional<Place> findByLatitude(Long latitude);
    Optional<Place> findByLongitude(Long longitude);
    Optional<Place> findByHeritage(HeritageFactor heritage);
}
