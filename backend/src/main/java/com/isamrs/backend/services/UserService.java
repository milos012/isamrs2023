package com.isamrs.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.User;
import com.isamrs.backend.repositories.UserRepository;



@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);

    }

    public User saveUser(User a){
        return userRepository.save(a);
    }

    public boolean deleteUserById(Long id){
        Optional<User> existing = userRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        userRepository.delete(existing.get());
        return true;
    }

    public User updateUser(User a){
        //TODO
        return a;
    }
    
}
