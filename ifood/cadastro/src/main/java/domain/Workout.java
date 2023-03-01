package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "workout")
public class Workout extends PanacheEntity {
    public String nome;
    @CreationTimestamp
    @Column(name = "creationDate")
    public LocalDateTime creationDate;
    @UpdateTimestamp
    @Column(name = "updateDate")
    public LocalDateTime updateDate;

}
