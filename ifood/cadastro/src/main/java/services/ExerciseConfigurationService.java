package services;

import domain.ExerciseConfiguration;
import domain.dto.ExerciseConfigurationDTO;

import javax.ws.rs.core.Response;
import java.util.List;

public interface ExerciseConfigurationService {
    List<ExerciseConfiguration> listAll();
    Response create(ExerciseConfigurationDTO dto);
    Response update(ExerciseConfigurationDTO dto);


}
