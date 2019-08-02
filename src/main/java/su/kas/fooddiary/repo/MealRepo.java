package su.kas.fooddiary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import su.kas.fooddiary.model.Meal;

@Repository
public interface MealRepo extends JpaRepository<Meal, Long> {
}
