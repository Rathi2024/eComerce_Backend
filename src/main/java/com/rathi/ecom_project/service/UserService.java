package com.rathi.ecom_project.service;


import com.rathi.ecom_project.dto.RegisterRequest;
import com.rathi.ecom_project.model.User;
import com.rathi.ecom_project.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public String registerUser(RegisterRequest request){

        if(userRepo.existsByUsername(request.getUsername())){
            return "Username already exist";
        }
        if(userRepo.existsByEmail(request.getEmail())){
            return "Email already exist";
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole("ROLE_USER");
        user.setEnabled(true);

        userRepo.save(user);

        return "User Registered Successfully";

    }
}
