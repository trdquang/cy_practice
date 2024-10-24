package myproject.controller.backend;

import myproject.util.VariableUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DashBoardCtr {

    @GetMapping("/admin/dashboard")
    String dashboard(){
        return VariableUtil.pathBe + "dashboard.html";
    }

    @GetMapping("/dashboard")
    String dashboard1(){
        return VariableUtil.pathBe + "dashboard.html";
    }
}
