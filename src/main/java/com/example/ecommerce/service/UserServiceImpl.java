package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
      Optional<User> userOptional =  userRepository.findById(id);
      if(userOptional.isPresent()){
         return userOptional.get();
      }
     //şimdilik null dursun ama doğrusu throw exception
        return null;
    }
}
