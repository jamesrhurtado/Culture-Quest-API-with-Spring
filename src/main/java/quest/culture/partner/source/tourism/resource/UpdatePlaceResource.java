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

    //other attributes cannot be updated for now
}
