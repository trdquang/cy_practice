package service.impl;

import dto.request.UserRequest;
import dto.response.UserResp;
import entity.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import search.UserSearch;
import service.IUserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserService  implements IUserService{
    private IUserRepository userRepo = new UserRepository();
    //------------------------------search
    @Override
    public List<UserResp> getAll(UserSearch userSearch) {
        List<User> userList = userRepo.getAll(userSearch);

        return userList.stream()
                .map(this::convertToRespone)
                .collect(Collectors.toList());
    }

    @Override
    public int edit(UserRequest userRequest) {
        User user = convertToUser(userRequest);
        userRepo.edit(user);
        return 0;
    }

    @Override
    public int deleteById(int id) {
        User user = userRepo.findById(id);
        userRepo.delete(user);
        return 0;
    }

    //-------------------------------------------------------  convert
    @Override
    public UserResp convertToRespone(User user) {
        return UserResp.builder()
                .id(user.getId())
                .createdate(user.getCreateDate())
                .updatedate(user.getUpdateDate())
                .fullname(user.getFullname())
                .build();
    }

    @Override
    public User convertToUser(UserRequest userRequest) {
        return User.builder() // Sử dụng User.builder()
                .id(userRequest.getId())
                .createDate(userRequest.getCreate_date())
                .updateDate(userRequest.getUpdate_date())// Giả sử đây là Date
                .fullname(userRequest.getFullname())
                .build();
    }

}
