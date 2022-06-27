package kuba.exam_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String email;
    private String password;

    @ManyToMany(targetEntity = Role.class,cascade = {CascadeType.PERSIST
            ,CascadeType.MERGE
            ,CascadeType.DETACH
            ,CascadeType.REFRESH},fetch = FetchType.EAGER)
 @JoinTable(name = "user_role",joinColumns ={@JoinColumn(name = "user_id")},
                                inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority>  grantedAuthorities = new ArrayList<>();
   for (Role roles: role){
       grantedAuthorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
   }
   return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return email;
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
