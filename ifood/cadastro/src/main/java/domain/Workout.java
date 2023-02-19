package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "workout")
public class Workout extends PanacheEntity {
    public String nome;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Exercise> exercise;
    @CreationTimestamp
    @Column(name = "creationDate")
    public LocalDateTime creationDate;
    @UpdateTimestamp
    @Column(name = "updateDate")
    public LocalDateTime updateDate;

}
