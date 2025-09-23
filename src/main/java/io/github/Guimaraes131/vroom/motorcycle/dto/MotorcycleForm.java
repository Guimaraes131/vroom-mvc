package io.github.Guimaraes131.vroom.motorcycle.dto;

import io.github.Guimaraes131.vroom.motorcycle.enums.MotorcycleModel;
import io.github.Guimaraes131.vroom.motorcycle.enums.ProblemCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorcycleForm {

        @NotBlank @Size(min = 7, max = 7)
        private String licensePlate;

        @NotBlank @Size(min = 17, max = 17)
        private String chassis;

        private String problemDescription;

        @NotNull
        private MotorcycleModel model;

        @NotNull
        private ProblemCategory problem;

        @NotNull
        private UUID tagId;

}
