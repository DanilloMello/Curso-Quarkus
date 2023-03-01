package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Exercise exercise;
}
