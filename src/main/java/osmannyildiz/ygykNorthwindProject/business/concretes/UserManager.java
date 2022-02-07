package osmannyildiz.ygykNorthwindProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.SuccessDataResult;
import osmannyildiz.ygykNorthwindProject.business.abstracts.IUserService;
import osmannyildiz.ygykNorthwindProject.dataAccess.abstracts.IUserDao;
import osmannyildiz.ygykNorthwindProject.entities.concretes.User;

@Service
public class UserManager implements IUserService {
	
	private IUserDao userDao;

	@Autowired
	public UserManager(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(userDao.getByEmail(email), "Kullanıcı getirildi.");
	}

	@Override
	public DataResult<User> add(User user) {
		return new SuccessDataResult<User>(userDao.save(user), "Kullanıcı eklendi.");
	}

}
