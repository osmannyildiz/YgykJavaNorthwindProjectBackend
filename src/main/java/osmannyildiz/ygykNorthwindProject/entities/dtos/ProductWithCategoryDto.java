package osmannyildiz.ygykNorthwindProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Category;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDto {

	protected int id;
	protected String name;
	protected String categoryName;
		
}
