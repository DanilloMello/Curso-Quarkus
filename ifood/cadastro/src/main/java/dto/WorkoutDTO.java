package dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
@Data
@RegisterForReflection
public class WorkoutDTO {
    Long id;
    String nome;
    List<ExerciseDTO> exercises;
    LocalDateTime creationDate;
    LocalDateTime updateDate;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
