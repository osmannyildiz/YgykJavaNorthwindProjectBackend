package osmannyildiz.ygykNorthwindProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	protected int id;

//	@Column(name="category_id")
//	protected int categoryId;

	@Column(name="product_name")
	protected String name;

	@Column(name="unit_price")
	protected double unitPrice;

	@Column(name="units_in_stock")
	protected short unitsInStock;

	@Column(name="quantity_per_unit")
	protected String quantityPerUnit;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	protected Category category;
	
}
