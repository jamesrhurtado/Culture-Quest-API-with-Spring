package quest.culture.partner.source.tourism.resource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DestinationResource {
    private Long id;
    private String name;
    private String city;
    private String country;
    private String photoUrl;
}
