package myproject.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashBoardCtr {
    @GetMapping("/index")
    String hello(){
        return "Xin chao moi nguoi. Hê hee hê hee hê hê";
    }
}
