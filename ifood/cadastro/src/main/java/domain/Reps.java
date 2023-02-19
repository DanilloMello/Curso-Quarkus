package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.vertx.codegen.annotations.Nullable;
import lombok.Data;
import enums.TypeUnit;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.Null;
import java.time.Duration;

@Data
@Entity
public class Reps extends PanacheEntity {
    @OneToOne
    @MapsId
    public ExerciseConfiguration exerciseConfiguration;
    @Nullable
    public Integer reps;
    @Nullable
    public Duration time;

    public Reps(Duration time) {
        this.reps = null;
        this.time = time;
    }
    public Reps(Integer reps) {
        this.reps = reps;
        this.time = null;
    }
}
