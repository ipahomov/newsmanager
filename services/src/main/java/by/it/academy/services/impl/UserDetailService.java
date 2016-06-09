package by.it.academy.services.impl;

import by.it.academy.model.user.UserDetail;
import by.it.academy.services.IUserDetailService;
import by.it.academy.services.IUserService;
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
