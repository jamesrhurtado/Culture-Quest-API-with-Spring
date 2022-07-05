package quest.culture.partner.source.tourism.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quest.culture.partner.source.tourism.domain.model.entity.Destination;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Optional<Destination> findByName(String name);
    Optional<Destination> findByCountry(String country);
}
