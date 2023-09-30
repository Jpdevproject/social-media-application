package com.in28minutes.ranga.socialmediaapplication.users;

import com.in28minutes.ranga.socialmediaapplication.users.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private  static List<User> users=new ArrayList<>();
    private static int id=0;
    static {
        users.add(new User(++id,"Sachin", LocalDate.now().minusYears(30)));
        users.add(new User(++id,"Avinash", LocalDate.now().minusYears(35)));
        users.add(new User(++id,"Jp", LocalDate.now().minusYears(30)));
    }

    public List<User> findAll(){
        return users;
    }
    public User findOne(int userId){
        return users.stream()
                .filter(user -> userId==user.getId())
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("User not found"));
    }
    public User saveUser(User newuser){
        newuser.setId(++id);
        users.add(newuser);
        return newuser;
    }

}
