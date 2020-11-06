package com.dyt.doyourthing.controller;

import com.dyt.doyourthing.entity.User;
import com.dyt.doyourthing.model.AddressD;
import com.dyt.doyourthing.model.AddressDetails;
import com.dyt.doyourthing.model.UserD;
import com.dyt.doyourthing.model.UserDetails;
import com.dyt.doyourthing.service.DoYourThingService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@RestController
public class DoYourThingController {

    @Autowired
    DoYourThingService doYourThingService;

    /**
     * Method to get all users
     * @return JSON String
     */
    @GetMapping(path = "/getAllUsers")
    public String getAllUsers() {
        String userString = null;
        List<User> userList = doYourThingService.getAllUsers();
        if(Objects.nonNull(userList)) {
            List<UserD> usersList = getUserOutput(userList);
            userString = new Gson().toJson(usersList);
        }
        return userString;
    }

    /**
     * Method to get user from any one input - name, username,email
     * @param userDetails
     * @return JSON String
     */
    @PostMapping(path = "/getUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUserByInput(@RequestBody UserDetails userDetails) {
        String userString = null;
        User user = doYourThingService.getUserByInput(userDetails);
        if(Objects.nonNull(user)) {
            UserD userOut = createOutUser(user);
            userString = new Gson().toJson(userOut);
        }
        return userString;
    }

    /**
     * Method to get list of users living on one steet
     * @param addressDetails
     * @return JSON String
     */
    @PostMapping(path = "/getUserByStreet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUserByStreet(@RequestBody AddressDetails addressDetails) {
        String userString = null;
        List<User> userList = doYourThingService.getUserByStreet(addressDetails);
        if(Objects.nonNull(userList)) {
            List<UserD> usersList = getUserOutput(userList);
            userString = new Gson().toJson(usersList);
        }
        return userString;
    }

    /**
     * Method to get user by ID - Can also be done with RequestParam approach - however I just used PathVariable instead
     * @param id
     * @return JSON String
     */
    @GetMapping(path = "/getById/{id}")
    public String getById(@PathVariable(value = "id") Long id) {
        String userString = null;
        User user = doYourThingService.getById(id);
        if(Objects.nonNull(user)) {
            UserD userD = createOutUser(user);
            userString = new Gson().toJson(userD);
        }
        return userString;
    }

    /**
     * Method to get user by username - Can also be done with RequestParam approach - however I just used PathVariable instead
     * @param userName
     * @return JSON String
     */
    @GetMapping(path = "/getByUserName/{username}")
    public String getByUserName(@PathVariable(value ="username") String userName) {
        String userString = null;
        User user = doYourThingService.getByUserName(userName);
        if(Objects.nonNull(user)) {
            UserD userD = createOutUser(user);
            userString = new Gson().toJson(userD);
        }
        return userString;
    }

    /**
     * Method to get user by email - Can also be done with RequestParam approach - however I just used PathVariable instead
     * @param email
     * @return JSON String
     */
    @GetMapping(path = "/getByEmail/{email}")
    public String getByEmail(@PathVariable(value ="email") String email) {
        String userString = null;
        User user = doYourThingService.getByEmail(email);
        if(Objects.nonNull(user)) {
            UserD userD = createOutUser(user);
            userString = new Gson().toJson(userD);
        }
        return userString;
    }

    /**
     * Method to get users by name
     * Kept this method as there might be multiple people with same name.
     * @param firstName
     * @param lastname
     * @return JSON String
     */
    @GetMapping(path = "/getByName")
    public String getByName(@RequestParam(value ="firstname") String firstName,@RequestParam(value ="lastname") String lastname) {
        String userString = null;
        String name = firstName.trim()+" "+lastname.trim();
        List<User> user = doYourThingService.getByName(name);
        if(Objects.nonNull(user)) {
            List<UserD> userD = getUserOutput(user);
            userString = new Gson().toJson(userD);
        }
        return userString;
    }

    /**
     *
     * @param user
     * @return UserD
     */
    private UserD createOutUser(User user) {
        UserD outUser = new UserD();
        AddressD address = new AddressD();
        outUser.setId(user.getId());
        outUser.setName(user.getName());
        outUser.setUserName(user.getUserName());
        outUser.setEmail(user.getEmail());
        if(Objects.nonNull(user.getAddress())) {
            address.setStreet(user.getAddress().getStreet());
            address.setCity(user.getAddress().getCity());
            address.setZipCode(user.getAddress().getZipCode());
        }
        outUser.setAddress(address);
        outUser.setPhone(user.getPhone());
        return outUser;
    }

    /**
     *
     * @param userList
     * @return List<UserD>
     */
    private List<UserD> getUserOutput(List<User> userList) {
        List<UserD> outList = new LinkedList<>();
        userList.forEach(u -> {
            UserD user = new UserD();
            AddressD address = new AddressD();
            user.setId(u.getId());
            user.setName(u.getName());
            user.setUserName(u.getUserName());
            user.setEmail(u.getEmail());
            if(Objects.nonNull(u.getAddress())) {
                address.setStreet(u.getAddress().getStreet());
                address.setCity(u.getAddress().getCity());
                address.setZipCode(u.getAddress().getZipCode());
            }
            user.setAddress(address);
            user.setPhone(u.getPhone());
            outList.add(user);
        });
        return outList;
    }
}
