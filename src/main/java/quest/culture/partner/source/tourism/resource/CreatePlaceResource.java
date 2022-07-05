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
    @NotBlank
    private Long altitude;

    @NotNull
    @NotBlank
    private Long latitude;

    @NotNull
    @NotBlank
    private Long longitude;

    @NotNull
    @NotBlank
    private String heritage;


}
