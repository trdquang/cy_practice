package myproject.service.impl;

import myproject.dto.request.UserRequest;
import myproject.dto.response.UserResponse;
import myproject.entity.User;
import myproject.repository.IUserRepository;
import myproject.repository.impl.UserRepository;
import myproject.search.UserSearch;
import myproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository ;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<UserResponse> getAll(UserSearch userSearch) {
//        return List.of();
        return userRepository.getAll(new UserSearch()).stream()
                .map(this::convertToResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public UserResponse convertToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .fullname(user.getFullname())
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .active(user.getActive())
                .create_date(user.getCreate_date())
                .update_date(user.getUpdate_date())
                .build();
    }

    @Override
    public User convertToUser(UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .fullname(userRequest.getFullname())
                .avatar(userRequest.getAvatar())
                .email(userRequest.getEmail())
                .active(userRequest.getActive())
                .create_date(userRequest.getCreate_date())
                .update_date(userRequest.getUpdate_date())
                .build();
    }
}
