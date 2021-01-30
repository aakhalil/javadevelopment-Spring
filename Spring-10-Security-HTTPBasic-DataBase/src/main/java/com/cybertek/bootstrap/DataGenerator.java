package com.cybertek.bootstrap;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataGenerator implements CommandLineRunner {

   private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DataGenerator(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public void run(String... args) throws Exception {

        // delete all
        this.userRepository.deleteAll();

// create users
        User employee = new User("ashraf", passwordEncoder.encode("icreate123"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1,ACcESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST");


        // save all
        List<User> users = Arrays.asList(employee, admin, manager);
        userRepository.saveAll(users);


    }




}
