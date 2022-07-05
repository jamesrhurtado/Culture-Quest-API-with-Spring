package quest.culture.partner.source.tourism.resource;

import lombok.*;
import quest.culture.partner.source.tourism.domain.model.enums.HeritageFactor;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PlaceResource {
    private Long id;
    private String name;
    private Long altitude;
    private Long longitude;
    private Long latitude;
    private HeritageFactor heritage;
    private DestinationResource destination;
}
