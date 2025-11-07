package io.github.Guimaraes131.vroom.motorcycle.enums;

import lombok.Getter;

@Getter
public enum ProblemCategory {
    MECHANICAL("rgb(255, 0, 0)", "Mecânico"),
    ELECTRICAL("rgb(0, 0, 255)", "Elétrico"),
    DOCUMENTATION("rgb(0, 255, 0)", "Documentação"),
    AESTHETIC("rgb(255, 255, 0)", "Estético"),
    SAFETY("rgb(255, 50, 0)", "Segurança"),
    MULTIPLE("rgb(150, 0, 0)", "Múltiplos"),
    COMPLIANT("rgb(130, 0, 255)", "Conforme");

    private final String associatedColor;
    private final String value;

    ProblemCategory(String color, String value) {
        this.associatedColor = color;
        this.value = value;
    }
}
