package domain.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@RegisterForReflection
public class WorkoutDTO {
    Long id;
    String nome;
    LocalDateTime creationDate;
    LocalDateTime updateDate;

}
