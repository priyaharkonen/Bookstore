package hh.backend.bookstore.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.backend.bookstore.domain.User;
import hh.backend.bookstore.domain.UserRepository;

@Service 
public class UserServiceDetailsImpl implements UserDetailsService {

    // private final UserRepository repository;

    private final UserRepository repository;

    public UserServiceDetailsImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User currentUser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPasswordHash(),
        AuthorityUtils.createAuthorityList(currentUser.getRole()));
        
        return user;
        
    }



}
