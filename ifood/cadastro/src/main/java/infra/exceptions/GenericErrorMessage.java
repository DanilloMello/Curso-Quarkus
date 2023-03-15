package infra.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@EqualsAndHashCode
public class GenericErrorMessage {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Generic unknowledge error", required = false)
    private String path;
    @Schema(description = "Message about the Error", required = true)
    private String message;

    public GenericErrorMessage(String path, String message) {
        this.path = path;
        this.message = message;
    }

    public GenericErrorMessage(String message) {
        this.path = null;
        this.message = message;
    }

    public GenericErrorMessage() {
    }
}
