package com.kursa4.services;

import com.kursa4.entities.Role;
import com.kursa4.entities.User;
import com.kursa4.repositories.RoleRepository;
import com.kursa4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User saveUser(User user) {
        user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
//        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRole(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
}
