package com.hema.medical_backend_spring.services;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hema.medical_backend_spring.model.ProjectUser;
import com.hema.medical_backend_spring.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(ProjectUser user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

    }

    public boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private static final Pattern EMAIL_PATTERN = Pattern
            .compile("^[A-Za-z0-9][A-Za-z0-9._%+-]*@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public  Optional<ProjectUser> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

}
