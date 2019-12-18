package rs.raf.sk.mongo_demo.dao;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import rs.raf.sk.mongo_demo.domain.QUser;
import rs.raf.sk.mongo_demo.domain.User;

public interface UserDao extends MongoRepository<User, String>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

    Page<User> findByFirstNameStartingWith(String prefix);

    @Override
    default void customize(QuerydslBindings querydslBindings, QUser qUser) {
        querydslBindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
