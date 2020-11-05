package com.dyt.doyourthing.service;

import com.dyt.doyourthing.entity.User;
import com.dyt.doyourthing.model.AddressDetails;
import com.dyt.doyourthing.model.UserDetails;

import java.util.List;

public interface DoYourThingService {

    List<User> getAllUsers();
    User getUserByInput(UserDetails userDetails);
    List<User> getUserByStreet(AddressDetails street);
    User getById(Long id);
    User getByUserName(String userName);
    User getByEmail(String email);
    List<User> getByName(String name);
}
