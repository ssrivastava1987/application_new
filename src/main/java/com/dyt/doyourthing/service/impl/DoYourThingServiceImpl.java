package com.dyt.doyourthing.service.impl;

import com.dyt.doyourthing.entity.User;
import com.dyt.doyourthing.model.AddressDetails;
import com.dyt.doyourthing.model.UserDetails;
import com.dyt.doyourthing.repositories.UserRepository;
import com.dyt.doyourthing.service.DoYourThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DoYourThingServiceImpl implements DoYourThingService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByInput(UserDetails userDetails) {
        User user = new User();
        if(Objects.nonNull(userDetails)){
            if(Objects.nonNull(userDetails.getUserName())){
                user = userRepository.findByUserName(userDetails.getUserName());
            } else if(Objects.nonNull(userDetails.getEmail())){
                user = userRepository.findByEmail(userDetails.getEmail());
            }
        }
        return user;
    }

    @Override
    public List<User> getUserByStreet(AddressDetails addressDetails) {
        List<User> users = new ArrayList<>();
        if(Objects.nonNull(addressDetails)){
            if(Objects.nonNull(addressDetails.getStreet())) {
                String st = addressDetails.getStreet();
                users = userRepository.findByStreet(st.trim());
            }
        }
        return users;
    }

    @Override
    public User getById(Long id) {
        User user = new User();
        if(Objects.nonNull(id)){
            Optional<User> userOpt = userRepository.findById(id);
            if(userOpt.isPresent()) {
                user = userOpt.get();
            }
        }
        return user;
    }

    @Override
    public User getByUserName(String userName) {
        User user = new User();
        if(Objects.nonNull(userName)){
            user = userRepository.findByUserName(userName);
        }
        return user;
    }

    @Override
    public User getByEmail(String email) {
        User user = new User();
        if(Objects.nonNull(email)){
            user = userRepository.findByEmail(email);
        }
        return user;
    }

    @Override
    public List<User> getByName(String name) {
        List<User> users = new ArrayList<>();
        if(Objects.nonNull(name)){
            if(Objects.nonNull(name)) {
                users = userRepository.findByName(name);
            }
        }
        return users;
    }
}
