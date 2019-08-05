package su.kas.fooddiary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import su.kas.fooddiary.repo.MealRepo;

@Controller
@RequiredArgsConstructor
public class MealController {
    private final MealService ms;
    private final MealRepo mr;

    @GetMapping("/meals")
    public String getMealsView(Model model) {
        model.addAttribute("meals", ms.findAll());
        return "meals";
    }

    @GetMapping("/meal/{id}")
    public String getMealView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("meal", ms.findById(id));
        return "meal";
    }
}