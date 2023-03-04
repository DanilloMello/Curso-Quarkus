package domain.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.Duration;

@Data
@RegisterForReflection
public class RepsDTO {
    public Integer reps;
    public Duration time;
}
