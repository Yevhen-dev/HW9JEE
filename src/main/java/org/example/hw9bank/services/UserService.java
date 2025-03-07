package org.example.hw9bank.services;

import org.example.hw9bank.domains.User;
import org.example.hw9bank.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }


    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll();
    }



}
