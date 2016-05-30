package by.it.academy.services;

import by.it.academy.model.user.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IPahomov on 28.05.2016.
 */
@Service("userDetailService")
@Transactional
public class UserDetailService extends BaseService<UserDetail, Long> implements IUserDetailService {

    @Autowired
    private IUserService userService;
}
