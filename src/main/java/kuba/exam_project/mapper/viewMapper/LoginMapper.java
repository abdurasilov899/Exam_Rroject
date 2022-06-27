package kuba.exam_project.mapper.viewMapper;

import kuba.exam_project.dto.response.LoginResponse;
import kuba.exam_project.entity.Role;
import kuba.exam_project.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LoginMapper {
    public LoginResponse loginView(String token, String message, User user) {
        var loginResponse = new LoginResponse();
        if (user != null) {
            setAuthority(loginResponse, user.getRole());
        }
        loginResponse.setJwtToken(token);
        loginResponse.setMessages(message);
        return loginResponse;
    }

    private void setAuthority(LoginResponse loginResponse, List<Role> roles) {
        Set<String> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(role.getRoleName());
        }
        loginResponse.setAuthorities(authorities);
    }
}

