package domain.embedded;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.Duration;


@Data
@Embeddable
public class Reps {
    public Integer repetition;
    public Duration runtime;

}
