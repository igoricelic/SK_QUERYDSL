package rs.raf.sk.mongo_demo.service;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rs.raf.sk.mongo_demo.domain.User;

public interface UserService {

    Page<User> findAll(Predicate predicate, Pageable pageable);

    User save(User user);

}
