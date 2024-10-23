package service.impl;

import dto.request.UserRequest;
import dto.response.UserResp;
import entity.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import search.UserSearch;
import service.IUserService;

import java.util.Date;
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
    public Long getTotalPage(UserSearch userSearch) {
        return userRepo.getTotalPage(userSearch);
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
                .userName(user.getUsername())
                .passWord(user.getPassword())
                .fullName(user.getFullname())
                .active(user.getActive())
                .avatar(user.getAvatar())
                .role(user.getRole())
                .createdate(user.getCreateDate())
                .updatedate(user.getUpdateDate())
                .build();
    }

    @Override
    public User convertToUser(UserRequest userRequest) {
        return User.builder() // Sử dụng User.builder()
                .id(userRequest.getId())
                .username(userRequest.getUserName())
                .password(userRequest.getPassWord())
                .fullname(userRequest.getFullName())
                .active(userRequest.getActive())
                .avatar(userRequest.getAvatar())
                .role(userRequest.getRole())
                .createDate(userRequest.getCreateDate())
                .updateDate(userRequest.getUpdateDate())
                .build();
    }

}
