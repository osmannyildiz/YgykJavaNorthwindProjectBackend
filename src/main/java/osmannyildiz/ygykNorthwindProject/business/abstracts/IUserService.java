package osmannyildiz.ygykNorthwindProject.business.abstracts;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.ygykNorthwindProject.entities.concretes.User;

public interface IUserService {
	
	DataResult<User> getByEmail(String email);
	DataResult<User> add(User user);

}
