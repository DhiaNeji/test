package ConsomiTounsi.configuration.security;

import ConsomiTounsi.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private String username;
    private String password;
    private boolean enabled ;
    private boolean locked ;
    private GrantedAuthority authority;

    public UserDetails(User user) {
    this.username=user.getUsernameUser();
    this.password=user.getPasswordUser();
    this.enabled=user.isEnabled();
    this.locked=user.isLocked();
    this.authority= new SimpleGrantedAuthority("ROLE_" + user.getRoleUser().name());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
