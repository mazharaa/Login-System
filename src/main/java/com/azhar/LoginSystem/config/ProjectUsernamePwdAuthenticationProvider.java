package com.azhar.LoginSystem.config;

import com.azhar.LoginSystem.model.Privilege;
import com.azhar.LoginSystem.model.Role;
import com.azhar.LoginSystem.model.User;
import com.azhar.LoginSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ProjectUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<User> user = userRepository.findByUsername(username);
        Role userRole = user.get(0).getRole();

        if (user.size() > 0) {
            if (passwordEncoder.matches(pwd, user.get(0).getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(userRole, userRole.getPrivileges()));
            } else {
                throw new BadCredentialsException("Invalid Password!");
            }
        } else {
            throw new BadCredentialsException("User doesn't exist!");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Role role, Set<Privilege> privileges) {
        List<GrantedAuthority> grantedAuthorities =new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

        for (Privilege privilege : privileges) {
            grantedAuthorities.add(new SimpleGrantedAuthority(privilege.getName()));
        }

        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
