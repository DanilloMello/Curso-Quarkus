package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.tuple.GeneratedValueGeneration;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "workout")
public class Workout extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workout_sequence")
    @SequenceGenerator(name = "workout_sequence", sequenceName = "workout_seq", allocationSize = 1)
    public Long id;
    public String nome;
    @CreationTimestamp
    @Column(name = "creationDate")
    public LocalDateTime creationDate;
    @UpdateTimestamp
    @Column(name = "updateDate")
    public LocalDateTime updateDate;

}
