package bg.softuni.portfolio.model.entity.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;

public class PortfolioUser implements UserDetails {

    private final String username;
    private final String password;
    private final String email;
    private final BigDecimal budget;
    private final Collection<GrantedAuthority> authorities;

    public PortfolioUser(String username, String password, String email, BigDecimal budget, Collection<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.budget = budget;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
