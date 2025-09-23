package io.github.Guimaraes131.vroom.motorcycle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/motorcycle")
public class MotorcycleController {

    private final MotorcycleService service;

    @GetMapping("/form")
    public String createMotorcycleForm() {
        return "form";
    }
}
