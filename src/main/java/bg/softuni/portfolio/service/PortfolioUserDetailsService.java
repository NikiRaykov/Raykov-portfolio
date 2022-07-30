package bg.softuni.portfolio.service;


import bg.softuni.portfolio.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class PortfolioUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PortfolioUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(u -> new User(
                        u.getUsername(),
                        u.getPassword(),
                        u.getUserRoles().stream()
                                .map(r -> new SimpleGrantedAuthority("ROLE_ " + r.getUserRole().name()))
                        .collect(Collectors.toList())
                        )).orElseThrow(() -> new UsernameNotFoundException("User with" + username + " not found."));
    }
}
