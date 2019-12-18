package rs.raf.sk.mongo_demo.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rs.raf.sk.mongo_demo.dao.UserDao;
import rs.raf.sk.mongo_demo.domain.User;
import rs.raf.sk.mongo_demo.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public Page<User> findAll(Predicate predicate, Pageable pageable) {
        return userDao.findAll(new BooleanBuilder().and(predicate), pageable);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
