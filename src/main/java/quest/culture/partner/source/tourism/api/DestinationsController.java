package quest.culture.partner.source.tourism.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import quest.culture.partner.source.tourism.domain.service.DestinationService;
import quest.culture.partner.source.tourism.mapping.DestinationMapper;

import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Operation(summary = "Create Destination", description = "Create Destination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationResource.class)
                    ))
    })
    @PostMapping
    public DestinationResource createDestination(@RequestBody CreateDestinationResource resource) {
        return mapper.toResource(destinationService.create(mapper.toModel(resource)));
    }
    @DeleteMapping("{destinationId}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long destinationId) {
        return destinationService.delete(destinationId);
    }
}
