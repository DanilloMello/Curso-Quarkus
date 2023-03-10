package services;

import infra.domain.Exercise;
import infra.domain.dto.ExerciseDTO;

import javax.ws.rs.core.Response;
import java.util.List;

public interface ExerciseService {
    List<Exercise> listAll();
    Response create(ExerciseDTO dto);
    Response update(ExerciseDTO dto);
    Response delete(Long id);
}
