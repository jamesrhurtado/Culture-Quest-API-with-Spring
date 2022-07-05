package quest.culture.partner.source.tourism.service;

import quest.culture.partner.source.shared.exception.ResourceNotFoundException;
import quest.culture.partner.source.shared.exception.ResourceValidationException;
import quest.culture.partner.source.tourism.domain.model.entity.Destination;
import quest.culture.partner.source.tourism.domain.persistence.DestinationRepository;
import quest.culture.partner.source.tourism.domain.service.DestinationService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Optional;
import java.util.Set;

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

        Optional<Destination> destinationWithName = destinationRepository.findByName(destination.getName());
        Optional<Destination> destinationWithCountry = destinationRepository.findByCountry(destination.getCountry());

        if(destinationWithName.isPresent() && destinationWithCountry.isPresent())
            throw new ResourceValidationException(ENTITY, "A destination with that combination of name and country already exists.");
        return destinationRepository.save(destination);
    }
}
