package com.example.spring_mvc_example_01.User;

import com.example.spring_mvc_example_01.Error.UserAlreadyExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public User registerNewUser(User user) throws UserAlreadyExistException{

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Username already exist!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
