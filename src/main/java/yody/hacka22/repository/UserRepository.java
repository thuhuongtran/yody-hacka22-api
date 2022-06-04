package yody.hacka22.repository;

import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yody.hacka22.dao.UserDao;
import yody.hacka22.entity.User;

import java.util.logging.Logger;

@Repository
public class UserRepository {
    Logger logger = Logger.getLogger(UserRepository.class.getName());
    @Autowired
    UserDao userDao;

    public User createUser(User user){
        try {
            User response = userDao.save(user);
            return response;
        }
        catch (Exception exception){
            logger.info("Error when create user");
        }
        return null;
    }
}
