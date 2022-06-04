package yody.hacka22.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yody.hacka22.dao.UserDao;
import yody.hacka22.dto.LoginRequest;
import yody.hacka22.entity.Business;
import yody.hacka22.entity.TemplateShirt;
import yody.hacka22.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class UserRepository {
    Logger logger = Logger.getLogger(UserRepository.class.getName());
    @Autowired
    UserDao userDao;
    @Autowired
    MongoTemplate mongoTemplate;

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

    public Optional<User> getUser(String id){
        try {
            Optional<User> response = userDao.findById(id);
            return response;
        }
        catch (Exception exception){
            logger.info("Error when create user");
        }
        return null;
    }

    public Boolean verify(LoginRequest loginRequest){
        try{
            Query query = new Query();
            query.addCriteria(Criteria.where("loginNamed").regex(loginRequest.getPassWord()));
            List<TemplateShirt> list =  mongoTemplate.find(query,TemplateShirt.class);
            if (list!= null && list.size() > 0){
                return true;
            }
            return false;
        }
        catch (Exception exception){
            return false;
        }
    }
}
