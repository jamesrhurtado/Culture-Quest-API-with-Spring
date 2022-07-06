package quest.culture.partner.source.tourism.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class UpdatePlaceResource {

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
