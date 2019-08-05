package su.kas.fooddiary;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import su.kas.fooddiary.model.Meal;
import su.kas.fooddiary.repo.MealRepo;

@Service
@RequiredArgsConstructor
public class MealService {
	private final MealRepo mr;

	public Meal findById(Long id) {
		return mr.findById(id).orElseThrow(() -> new RuntimeException("no meal with id: #" + id));
	}

	public List<Meal> findAll() {
		return mr.findAll();
	}
}
