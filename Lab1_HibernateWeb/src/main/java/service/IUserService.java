package service;

import dto.request.UserRequest;
import dto.response.UserResp;
import entity.User;
import search.UserSearch;

import java.util.List;

public interface IUserService {

    //------------tim kiem
    List<UserResp> getAll(UserSearch userSearch);

    UserResp convertToRespone(User user);
    User convertToUser(UserRequest userRequest);
    int edit(UserRequest userRequest);
    int deleteById (int id);
}
