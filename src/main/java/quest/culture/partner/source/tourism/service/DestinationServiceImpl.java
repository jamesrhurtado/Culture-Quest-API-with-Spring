package quest.culture.partner.source.tourism.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quest.culture.partner.source.shared.exception.ResourceNotFoundException;
import quest.culture.partner.source.shared.exception.ResourceValidationException;
import quest.culture.partner.source.tourism.domain.model.entity.Destination;
import quest.culture.partner.source.tourism.domain.persistence.DestinationRepository;
import quest.culture.partner.source.tourism.domain.service.DestinationService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Optional;
import java.util.Set;

@Service
public class DestinationServiceImpl implements DestinationService {

    private static final String ENTITY = "Destination";
    private final DestinationRepository destinationRepository;
    private final Validator validator;

    public DestinationServiceImpl(DestinationRepository destinationRepository, Validator validator) {
        this.destinationRepository = destinationRepository;
        this.validator = validator;
    }

    @Override
    public Destination getById(Long destinationId) {
        return destinationRepository.findById(destinationId).orElseThrow(()->new ResourceNotFoundException(ENTITY, destinationId));
    }

    @Override
    public Destination create(Destination destination) {
        Set<ConstraintViolation<Destination>> violations = validator.validate(destination);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Destination destinationWithName = destinationRepository.findByName(destination.getName());
        Destination destinationWithCountry = destinationRepository.findByCountry(destination.getCountry());

        if(destinationWithName!= null && destinationWithCountry!=null)
            throw new ResourceValidationException(ENTITY, "A destination with that combination of name and country already exists.");
        return destinationRepository.save(destination);
    }
    @Override
    public ResponseEntity<?> delete(Long destinationId) {
        return destinationRepository.findById(destinationId).map(destination -> {
            destinationRepository.delete(destination);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, destinationId));
    }
}
