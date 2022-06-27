package kuba.exam_project.service;

import kuba.exam_project.dto.request.RegisterRequest;
import kuba.exam_project.dto.response.RegisterResponse;
import kuba.exam_project.entity.User;
import kuba.exam_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public RegisterResponse creat(RegisterRequest registerRequest) {
        User user = mapToEntity(registerRequest);
        user.setPassword(encoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
        return mapToResponse(user);
    }

    public User mapToEntity(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public RegisterResponse mapToResponse(User user) {
        if (user == null) {
            return null;
        }
        RegisterResponse response = new RegisterResponse();
        if (user.getId() != null) {
            response.setId(String.valueOf(user.getId()));
        }
        response.setEmail(user.getEmail());
        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email not found"));
    }
}
