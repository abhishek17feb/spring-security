package com.eureka.spring.security.service;

import com.eureka.spring.security.beans.UserAuth;
import com.eureka.spring.security.entity.Student;
import com.eureka.spring.security.entity.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Student myStudent = Optional.ofNullable(studentRepository.findByName(userName))
                .orElseThrow(() -> new RuntimeException("No user found"));
        return new UserAuth(myStudent);
    }
}
