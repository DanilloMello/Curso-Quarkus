package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.vertx.codegen.annotations.Nullable;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "exercise")
public class Exercise extends PanacheEntity {
    public String name;
    @ManyToOne
    public Workout workout;
    @CreationTimestamp
    @Column(name = "dataCriacao")
    public LocalDateTime dataCriacao;
    @UpdateTimestamp
    @Column(name = "dataAtualizacao")
    public LocalDateTime dataAtualizacao;

}
