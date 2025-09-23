package io.github.Guimaraes131.vroom.motorcycle;

import io.github.Guimaraes131.vroom.motorcycle.dto.MotorcycleForm;
import io.github.Guimaraes131.vroom.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/motorcycle")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;
    private final UserService userService;

    @GetMapping("/form")
    public String createMotorcycleForm(@RequestParam(required = false) UUID tagId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        MotorcycleForm form = new MotorcycleForm();
        form.setTagId(tagId);

        model.addAttribute("username", username);
        model.addAttribute("motorcycleForm", form);

        return "form";
    }

    @GetMapping("/{id}")
    public String motorcycleDetails(@PathVariable UUID id, Model model) {
        Motorcycle motorcycle = motorcycleService.getById(id);

        model.addAttribute("motorcycle", motorcycle);
        return "motorcycle-details";
    }

    @PostMapping("/form")
    public String create(@Valid MotorcycleForm motorcycleForm, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "form";
        }

        motorcycleService.create(motorcycleService.toEntity(motorcycleForm));

        return "redirect:/tags";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        motorcycleService.delete(id);

        return "redirect:/tags";
    }
}
