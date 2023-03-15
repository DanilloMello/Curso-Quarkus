package infra.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "exercise")
public class Exercise extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_sequence")
    @SequenceGenerator(name = "exercise_sequence", sequenceName = "exercise_seq", allocationSize = 1)
    public Long id;
    public String name;
    @ManyToOne(fetch = FetchType.LAZY)
    public Workout workout;
    @CreationTimestamp
    @Column(name = "creationDate")
    public LocalDateTime creationDate;
    @UpdateTimestamp
    @Column(name = "updateDate")
    public LocalDateTime updateDate;

}
