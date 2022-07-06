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

/*  You shouldn't use CascadeType.ALL on @ManyToOne since entity state transitions should propagate
    from parent entities to child ones, not the other way around.
    The @ManyToOne side is always the Child association since it maps the underlying Foreign Key column.*/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;
}
