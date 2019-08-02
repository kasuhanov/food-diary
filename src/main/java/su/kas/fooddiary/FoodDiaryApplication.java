package su.kas.fooddiary;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import su.kas.fooddiary.model.Food;
import su.kas.fooddiary.model.Meal;
import su.kas.fooddiary.repo.MealRepo;

@EnableTransactionManagement
@SpringBootApplication
public class FoodDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDiaryApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(MealRepo repo) {
		return (args) -> {
			repo.findAll().forEach(System.out::println);

			Food food1 = new Food();
			food1.setName("Макорошки");
			food1.setQuantity("200");
			food1.setMeasure("гр");
			Food food2 = new Food(null, "Котлетка", "1", "шт", null);
			Meal c = new Meal(null, LocalDateTime.now(), Arrays.asList(
					food1,
					food2)
			);
			food1.setMeal(c);
			food2.setMeal(c);
			repo.save(c);
		};
	}
}
