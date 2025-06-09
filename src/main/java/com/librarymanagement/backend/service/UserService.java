package com.librarymanagement.backend.service;

import com.librarymanagement.backend.model.User;
import com.librarymanagement.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public User addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("user email already exists");
        }
        // Hash the password before saving to the database
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }
    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setName(updatedUser.getName());
        existingUser.setMobileNo(updatedUser.getMobileNo());

        if(updatedUser.getRole().equals("admin")){
            existingUser.setRole("admin");
        }else{
            existingUser.setRole("user");
        }
        // use encoder if needed

        return userRepository.save(existingUser);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
