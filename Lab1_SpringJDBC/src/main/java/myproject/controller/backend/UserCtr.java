package myproject.controller.backend;

import lombok.Getter;
import myproject.dto.response.UserResponse;
import myproject.repository.IUserRepository;
import myproject.repository.impl.UserRepository;
import myproject.search.UserSearch;
import myproject.service.IUserService;
import myproject.service.impl.UserService;
import myproject.util.VariableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserCtr {
    @Autowired
    private IUserService userService = new UserService();

    @GetMapping("/admin/user")
    String getUser(){
        return VariableUtil.pathBe + "user.html";
    }

}
