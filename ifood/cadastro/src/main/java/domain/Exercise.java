package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "exercise")
public class Exercise extends PanacheEntity {
    public String name;
    @ManyToOne
    public Workout workout;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<ExerciseConfiguration> exerciseConfiguration;
    @CreationTimestamp
    @Column(name = "creationDate")
    public LocalDateTime creationDate;
    @UpdateTimestamp
    @Column(name = "updateDate")
    public LocalDateTime updateDate;

}
