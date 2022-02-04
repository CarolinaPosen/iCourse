package by.itacademy.mikhalevich.icourse.model.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    public static final String ROLE_PREFIX = "ROLE_";
    private final Credential credential;
    private final Collection<SimpleGrantedAuthority> authorities;


    public UserPrincipal(Credential credential) {
        this.credential = credential;
        List<SimpleGrantedAuthority> roleList = credential.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role.getName()))
                .collect(Collectors.toList());

        List<SimpleGrantedAuthority> authorityList = credential.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());

        this.authorities = new ArrayList<>();
        this.authorities.addAll(roleList);
        this.authorities.addAll(authorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return credential.getUsername();
    }

    @Override
    public String getPassword() {
        return credential.getPassword();
    }

    @Override
    public boolean isEnabled() {
        return credential.isEnabled();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
