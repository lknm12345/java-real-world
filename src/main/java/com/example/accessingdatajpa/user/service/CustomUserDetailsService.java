package com.example.accessingdatajpa.user.service;

import com.example.accessingdatajpa.user.entity.AccountAdapter;
import com.example.accessingdatajpa.user.entity.User;
import com.example.accessingdatajpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) {
        User account = userRepository.findOneByEmail(email)
                .orElseThrow();

        return new AccountAdapter(account);
    }
}
