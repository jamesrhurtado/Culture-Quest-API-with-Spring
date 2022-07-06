package quest.culture.partner.source.tourism.domain.model.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    private String country;

    private String photoUrl;

    // Relationships
    /*The CascadeType.ALL is implemented in the @OneToMany side, which should also use the mappedBy attribute
    since it's the most efficient one-to-many table relationship mapping.*/
    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    protected Set<Place> places = new HashSet<>();
}
