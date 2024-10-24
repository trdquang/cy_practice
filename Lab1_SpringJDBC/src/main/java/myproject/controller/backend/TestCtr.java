package myproject.controller.backend;

import myproject.dto.request.UserRequest;
import myproject.dto.response.CommentResponse;
import myproject.dto.response.PostResponse;
import myproject.dto.response.UserResponse;
import myproject.entity.Comment;
import myproject.entity.Post;
import myproject.entity.User;
import myproject.repository.impl.CommentRepository;
import myproject.repository.impl.PostRepository;
import myproject.service.impl.CommentService;
import myproject.service.impl.PostService;
import myproject.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestCtr {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @GetMapping("/post")
    public List<PostResponse> getPost(){
        return postService.getAll();
    }

//    @GetMapping("/comment")
//    public List<CommentResponse> getComment(){
//        return commentService.getAll();
//    }

    @GetMapping("/user")
    public UserResponse getUserById(@RequestParam("id") long id) {
        return userService.getById(id); // Gọi service để lấy thông tin người dùng
    }

    @GetMapping("/comment")
    public List<CommentResponse> getCommentByPostId(@RequestParam("id") long id) {
        return commentService.getByPostId(id); // Gọi service để lấy thông tin người dùng
    }

    @PostMapping("user/add")
    public String add(){
        try {
            userService.add(new UserRequest(1L, "test", "pass test", "hehehehe"));
            return "add ok";
        }catch (Exception e){
            return "add failed";
        }
    }

}
