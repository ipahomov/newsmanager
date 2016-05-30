package by.it.academy.dao;

import by.it.academy.model.user.UserDetail;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by IPahomov on 04.05.2016.
 */
@Repository("userDetailDao")
public class UserDetailDao extends BaseDao<UserDetail, Long> implements IUserDetailDao {

    @Autowired
    public UserDetailDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
