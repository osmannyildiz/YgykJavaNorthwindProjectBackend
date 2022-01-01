package osmannyildiz.ygykNorthwindProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="product_id")
	protected int id;

	@Column(name="category_id")
	protected int categoryId;

	@Column(name="product_name")
	protected String name;

	@Column(name="unit_price")
	protected double unitPrice;

	@Column(name="units_in_stock")
	protected short unitsInStock;

	@Column(name="quantity_per_unit")
	protected String quantityPerUnit;
	
	public Product() {}
	
	public Product(
		int id, int categoryId, String name, double unitPrice, short unitsInStock, String quantityPerUnit
	) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
	}
	
}
