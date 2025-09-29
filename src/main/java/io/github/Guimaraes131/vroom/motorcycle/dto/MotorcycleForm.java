package io.github.Guimaraes131.vroom.motorcycle.dto;

import io.github.Guimaraes131.vroom.motorcycle.enums.MotorcycleModel;
import io.github.Guimaraes131.vroom.motorcycle.enums.ProblemCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorcycleForm {

        private String licensePlate;
        private String chassis;
        private String problemDescription;
        private MotorcycleModel model;
        private ProblemCategory problem;
        private UUID tagId;
}
