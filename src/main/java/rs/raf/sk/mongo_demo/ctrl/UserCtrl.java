package rs.raf.sk.mongo_demo.ctrl;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import rs.raf.sk.mongo_demo.domain.User;
import rs.raf.sk.mongo_demo.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserCtrl {

    private final UserService userService;

    @GetMapping
    public Page<User> findAll(Predicate predicate, @PageableDefault(page = 0, size = 5) Pageable pageable) {
        return userService.findAll(predicate, pageable);
    }

    @PostMapping
    public @ResponseBody User save(@RequestBody User user) {
        return userService.save(user);
    }

}
