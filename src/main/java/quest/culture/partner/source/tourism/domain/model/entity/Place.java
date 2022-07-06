package quest.culture.partner.source.tourism.domain.model.entity;
import lombok.*;
import quest.culture.partner.source.tourism.domain.model.enums.HeritageFactor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private Long altitude;

    @NotNull
    private Long latitude;

    @NotNull
    private Long longitude;

    @Enumerated(EnumType.STRING)
    private HeritageFactor heritage;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;
}
