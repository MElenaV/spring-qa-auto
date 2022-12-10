package com.spring.qa.auto.lesson2.controller.rest.example;

import org.springframework.web.bind.annotation.*;
import com.spring.qa.auto.lesson2.controller.rest.example.dto.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class CrudOperationExample {

    Map<Integer, User> data = new HashMap<>();

    @PostConstruct
    void init() {
        data.put(1, new User(1, "Jack","Wolf", 18));
        data.put(2, new User(2, "Alex","Adamson", 30));
        data.put(3, new User(3, "Phil","Ball", 25));
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return data.get(id);
    }

    @GetMapping("/all")
    public List<User> get() {
        return new ArrayList<>(data.values());
    }

    @PostMapping()
    public void save(@RequestBody User user) {
        int id = data.size() + 1;
        user.setId(id);
        data.put(id, user);
    }

    @PutMapping("/{id}")
    public void change(@PathVariable int id, @RequestBody User userChanging) {
        User user = data.get(id);
        user.setAge(userChanging.getAge());
        user.setFirstName(userChanging.getFirstName());
        user.setSecondName(userChanging.getSecondName());
        data.put(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        data.remove(id);
    }
}
