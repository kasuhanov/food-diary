package su.kas.fooddiary.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meal")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "foodList")
@Data
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="meal_seq_gen")
	@SequenceGenerator(name="meal_seq_gen", sequenceName="meal_seq")
	private Long id;
	private LocalDateTime time;
	@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Food> foodList;
}
