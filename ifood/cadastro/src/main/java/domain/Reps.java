package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import tiposEnum.TypeUnit;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Data
@Entity
public class Reps extends PanacheEntity {
    @OneToOne
    @MapsId
    public ExerciseConfiguration exerciseConfiguration;
    public Integer reps;
    public TypeUnit unit;

}
