package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Data
@Table(name = "Exercise_Configuration")
public class ExerciseConfiguration extends PanacheEntity {
    public Integer sets;
    public String cadence;
    public String method;
    public Double weight;
    public Integer rangeOfMotion;
    public Duration restBetweenSets;
    public Duration restBetweenReps;
    public Duration restBetweenExercises;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Reps reps;
    @ManyToOne(fetch = FetchType.LAZY)
    public Exercise exercise;

}
