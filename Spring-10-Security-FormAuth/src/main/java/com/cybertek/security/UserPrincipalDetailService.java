package com.cybertek.security;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserPrincipalDetailService implements UserDetailsService {


   private UserRepository userRepository;

    public UserPrincipalDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        if(user==null){
            throw new UsernameNotFoundException("User does not exists");
        }

        UserPrincipal userPrincipal= new UserPrincipal(user);

        return  userPrincipal;
    }
}
