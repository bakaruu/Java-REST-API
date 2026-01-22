package com.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    //Implements methods to retrieve info

    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Aru", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "Baka", LocalDate.now().minusYears(26)));
        users.add(new User(++userCount, "Jhon", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll() {
        return users;
    }


    public User findOne(int id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    // Functional programming
//    public User findOne(int id ){
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        return users.stream().filter(predicate).findFirst().get();
//    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

}
