package quest.culture.partner.source.tourism.api;

import quest.culture.partner.source.tourism.domain.service.DestinationService;
import quest.culture.partner.source.tourism.mapping.DestinationMapper;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quest.culture.partner.source.tourism.resource.CreateDestinationResource;
import quest.culture.partner.source.tourism.resource.DestinationResource;

@Tag(name = "Destinations")
@RestController
@RequestMapping("/api/v1/destinations")
public class DestinationsController {
    private final DestinationService destinationService;
    private final DestinationMapper mapper;

    public DestinationsController(DestinationService destinationService, DestinationMapper mapper) {
        this.destinationService = destinationService;
        this.mapper = mapper;
    }

    @GetMapping("{destinationId}")
    public DestinationResource getDestinationById(@PathVariable Long destinationId) {
        return mapper.toResource(destinationService.getById(destinationId));
    }

    @PostMapping
    public DestinationResource createDestination(@RequestBody CreateDestinationResource resource) {
        return mapper.toResource(destinationService.create(mapper.toModel(resource)));
    }
}
