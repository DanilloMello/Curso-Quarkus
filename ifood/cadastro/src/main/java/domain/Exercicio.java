package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
public class Exercicio extends PanacheEntity {
    String nome;
    @OneToOne(cascade = CascadeType.ALL)
    ConfiguracaoExercicio configuracaoExercicio;
    @ManyToOne
    Treino treino;


}
