package osmannyildiz.ygykNorthwindProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import osmannyildiz.ygykNorthwindProject.entities.concretes.User;

public interface IUserDao extends JpaRepository<User, Integer> {
	
	User getByEmail(String email);

}
