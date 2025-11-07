package io.github.Guimaraes131.vroom.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

    @NotBlank(message = "O login é obrigatório")
    @Size(min = 3, max = 20, message = "O login deve ter entre 3 e 20 caracteres")
    private String login;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String password;

    @NotBlank(message = "O tipo de usuário é obrigatório")
    private String role;
}
