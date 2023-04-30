package com.api.service.impl;

import com.api.entity.User;
import com.api.repo.UserRepo;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    public UserRepo getUserRepo() {
        return userRepo;
    }
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepo.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepo.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
