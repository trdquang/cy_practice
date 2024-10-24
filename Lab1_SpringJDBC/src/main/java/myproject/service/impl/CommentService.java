package myproject.service.impl;

import myproject.dto.response.CommentResponse;
import myproject.dto.response.UserResponse;
import myproject.entity.Comment;
import myproject.entity.User;
import myproject.repository.ICommentRepository;
import myproject.repository.impl.CommentRepository;
import myproject.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;

    @Override
    public List<CommentResponse> getAll() {
        return commentRepository.getAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public CommentResponse getById(long id) {
        return convertToResponse(commentRepository.getById(id));
    }

    @Override
    public List<CommentResponse> getByPostId(long id) {
        return commentRepository.getByPostId(id).stream()
                .map(this::convertToResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public CommentResponse convertToResponse(Comment comment) {
        UserResponse user = userService.getById(comment.getUser_id());

        return CommentResponse.builder()

                .user_comment(user.getFullname())
                .content_comment(comment.getComment_content())
                .build();
    }
}
