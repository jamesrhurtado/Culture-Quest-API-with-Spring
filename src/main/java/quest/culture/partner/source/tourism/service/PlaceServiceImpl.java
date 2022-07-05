package quest.culture.partner.source.tourism.service;

import quest.culture.partner.source.shared.exception.ResourceNotFoundException;
import quest.culture.partner.source.shared.exception.ResourceValidationException;
import quest.culture.partner.source.tourism.domain.model.entity.Place;
import quest.culture.partner.source.tourism.domain.persistence.DestinationRepository;
import quest.culture.partner.source.tourism.domain.persistence.PlaceRepository;
import quest.culture.partner.source.tourism.domain.service.PlaceService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class PlaceServiceImpl implements PlaceService {

    private static final String ENTITY = "Place";

    private final PlaceRepository placeRepository;

    private final Validator validator;

    private final DestinationRepository destinationRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository, Validator validator, DestinationRepository destinationRepository) {
        this.placeRepository = placeRepository;
        this.validator = validator;
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Place create(Long destinationId, Place place) {
        Set<ConstraintViolation<Place>> violations = validator.validate(place);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return destinationRepository.findById(destinationId).map(destination ->{
            place.setDestination(destination);
            return placeRepository.save(place);
        }).orElseThrow(()-> new ResourceNotFoundException("Destination", destinationId));
    }

    @Override
    public Place getByPlaceId(Long placeId) {
        return placeRepository.findById(placeId).orElseThrow(()->new ResourceNotFoundException(ENTITY, placeId));
    }

    @Override
    public Place update(Long destinationId, Long placeId, Place place) {
        Set<ConstraintViolation<Place>> violations = validator.validate(place);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!destinationRepository.existsById(destinationId))
            throw new ResourceNotFoundException("Destination", destinationId);

        return placeRepository.findById(placeId).map(existingPlace ->
                        placeRepository.save(existingPlace.withName(place.getName())))
                .orElseThrow(() -> new ResourceNotFoundException("Destination", destinationId));
    }
}
