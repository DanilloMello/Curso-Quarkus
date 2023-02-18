package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Data
@Entity
public class ConfiguracaoExercicio extends PanacheEntity {
    String cadencia;
    Integer series;
    Integer repeticoes;
    Instant descansoEntreSeries;
    Instant descansoEntreExercicios;
    Double carga;
}
