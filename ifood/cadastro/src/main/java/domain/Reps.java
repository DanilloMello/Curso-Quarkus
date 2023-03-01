package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Data
@Table(name = "reps")
public class Reps extends PanacheEntityBase {
    @Id
    public Long id;
    @OneToOne
    @MapsId
    public ExerciseConfiguration exerciseConfiguration;
    public Integer reps;
    public Duration time;
    public Reps() {

    }
    public Reps(Duration time) {
        this.reps = null;
        this.time = time;
    }
    public Reps(Integer reps) {
        this.reps = reps;
        this.time = null;
    }

}
