package services;

import infra.domain.ExerciseConfiguration;
import infra.domain.dto.ExerciseConfigurationDTO;

import javax.ws.rs.core.Response;
import java.util.List;

public interface ExerciseConfigurationService {
    List<ExerciseConfiguration> listAll();
    Response create(ExerciseConfigurationDTO dto);
    Response update(ExerciseConfigurationDTO dto);
    Response delete(Long id);
}
