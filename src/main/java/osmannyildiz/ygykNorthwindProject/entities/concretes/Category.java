package osmannyildiz.ygykNorthwindProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"})
public class Category {
	
	@Id
	@Column(name="category_id")
	protected int id;

	@Column(name="category_name")
	protected String name;
	
	@OneToMany(mappedBy="category")
	protected List<Product> products;

}
