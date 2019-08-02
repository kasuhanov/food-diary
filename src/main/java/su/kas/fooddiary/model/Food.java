package su.kas.fooddiary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "food")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "meal")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="food_seq_gen")
	@SequenceGenerator(name="food_seq_gen", sequenceName="food_seq")
	private Long id;
	private String name;
	private String quantity;
	private String measure;
	@ManyToOne
	@JoinColumn(name = "meal_id")
	@JsonIgnore
	private Meal meal;
}
