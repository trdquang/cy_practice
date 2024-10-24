package myproject.controller.backend;

import lombok.Getter;
import myproject.dto.response.UserResponse;
import myproject.repository.IUserRepository;
import myproject.repository.impl.UserRepository;
import myproject.search.UserSearch;
import myproject.service.IUserService;
import myproject.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserCtr {
    @Autowired
    private IUserService userService = new UserService();

    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/admin/user")
    List<UserResponse> getUser(){
        return userService.getAll(new UserSearch());
    }

    @GetMapping ("/test")
    String getTest(){
        return "1234";
    }
}
