package quest.culture.partner.source.tourism.domain.model.entity;
import lombok.*;
import quest.culture.partner.source.tourism.domain.model.enums.HeritageFactor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private HeritageFactor heritage;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;
}
