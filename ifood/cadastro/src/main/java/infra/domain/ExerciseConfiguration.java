package infra.domain;

import infra.domain.embedded.Reps;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Data
@Table(name = "exercise_configuration")
public class ExerciseConfiguration extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_configuration_sequence")
    @SequenceGenerator(name = "exercise_configuration_sequence", sequenceName = "exercise_configuration_seq", allocationSize = 1)
    public Long id;
    public Integer sets;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "repetition", column = @Column(name = "reps_repetition")),
            @AttributeOverride( name = "runtime", column = @Column(name = "reps_runtime"))
    })
    public Reps reps;
    public String cadence;
    public String method;
    public Double weight;
    public Integer rangeOfMotion;
    public Duration restBetweenSets;
    public Duration restBetweenReps;
    public Duration restBetweenExercises;
    @ManyToOne(fetch = FetchType.LAZY)
    public Exercise exercise;
}
