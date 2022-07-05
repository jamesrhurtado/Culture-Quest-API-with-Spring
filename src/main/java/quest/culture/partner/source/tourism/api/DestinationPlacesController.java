package quest.culture.partner.source.tourism.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import quest.culture.partner.source.tourism.domain.service.PlaceService;
import quest.culture.partner.source.tourism.mapping.PlaceMapper;
import quest.culture.partner.source.tourism.resource.CreatePlaceResource;
import quest.culture.partner.source.tourism.resource.DestinationResource;
import quest.culture.partner.source.tourism.resource.PlaceResource;
import quest.culture.partner.source.tourism.resource.UpdatePlaceResource;

@Tag(name = "Destinations")
@RestController
@RequestMapping("/api/v1/destinations/{destinationId}/places")
public class DestinationPlacesController {
    private final PlaceService placeService;
    private final PlaceMapper mapper;

    public DestinationPlacesController(PlaceService placeService, PlaceMapper mapper) {
        this.placeService = placeService;
        this.mapper = mapper;
    }

    @GetMapping("{placeId}")
    public PlaceResource getPlaceById(@PathVariable Long placeId) {
        return mapper.toResource(placeService.getByPlaceId(placeId));
    }


    @PostMapping
    public PlaceResource createPlace(@PathVariable Long destinationId,
                                     @RequestBody CreatePlaceResource resource) {
        return mapper.toResource(placeService.create(destinationId, mapper.toModel(resource)));
    }

    @PutMapping("{placeId}")
    public PlaceResource updatePlace(@PathVariable Long destinationId,
                                             @PathVariable Long placeId,
                                             @RequestBody UpdatePlaceResource resource) {
        return mapper.toResource(placeService.update(destinationId, placeId, mapper.toModel(resource)));
    }
}
