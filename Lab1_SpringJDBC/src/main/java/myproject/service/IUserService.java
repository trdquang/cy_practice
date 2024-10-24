package myproject.service;

import myproject.dto.request.UserRequest;
import myproject.dto.response.UserResponse;
import myproject.entity.User;
import myproject.search.UserSearch;

import java.util.List;

public interface IUserService {
    int count();
    List<UserResponse> getAll(UserSearch userSearch);

    UserResponse convertToResponse(User user);
    User convertToUser(UserRequest userRequest);
}
