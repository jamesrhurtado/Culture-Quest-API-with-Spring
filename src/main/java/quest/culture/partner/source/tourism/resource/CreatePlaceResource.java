package quest.culture.partner.source.tourism.resource;

import lombok.*;
import quest.culture.partner.source.tourism.domain.model.enums.HeritageFactor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlaceResource {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Long altitude;

    @NotNull
    private Long latitude;

    @NotNull
    private Long longitude;

    private String heritage;
}
