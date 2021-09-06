package ita.softserve.course_evaluation_analytics.security;

import ita.softserve.course_evaluation_analytics.entity.Users;
import ita.softserve.course_evaluation_analytics.repository.impl.UsersRepositoryImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepositoryImpl userRepository;

    public UserDetailsServiceImpl(UsersRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return UserDetailsImpl
                .fromUser(userRepository.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"))
                );
    }
}
