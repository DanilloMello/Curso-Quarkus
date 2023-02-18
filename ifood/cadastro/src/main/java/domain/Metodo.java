package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Metodo extends PanacheEntity {
    String nome;
    @ManyToOne
    ConfiguracaoExercicio configuracaoExercicio;
}
