package io.github.Guimaraes131.vroom.motorcycle.dto;

import io.github.Guimaraes131.vroom.motorcycle.enums.MotorcycleModel;
import io.github.Guimaraes131.vroom.motorcycle.enums.ProblemCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MotorcycleForm {

        @Size(min = 7, max = 7, message = "placa deve ter 7 caracteres")
        @NotNull(message = "campo obrigatório")
        private String licensePlate;

        @Size(min = 17, max = 17, message = "chassi deve ter 17 caracteres")
        @NotNull(message = "campo obrigatório")
        private String chassis;

        private String problemDescription;
        private MotorcycleModel model;
        private ProblemCategory problem;
        private UUID tagId;
}
