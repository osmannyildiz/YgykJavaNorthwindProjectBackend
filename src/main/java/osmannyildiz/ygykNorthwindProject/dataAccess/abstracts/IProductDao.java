package osmannyildiz.ygykNorthwindProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;

public interface IProductDao extends JpaRepository<Product, Integer> {

}
