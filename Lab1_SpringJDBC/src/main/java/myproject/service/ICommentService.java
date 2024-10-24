package myproject.service;

import myproject.dto.request.PostRequest;
import myproject.dto.response.CommentResponse;
import myproject.dto.response.PostResponse;
import myproject.dto.response.UserResponse;
import myproject.entity.Comment;
import myproject.entity.Post;
import myproject.repository.impl.CommentRepository;
import myproject.search.UserSearch;

import java.util.List;

public interface ICommentService {
    List<CommentResponse> getAll();
    CommentResponse getById(long id);
    List<CommentResponse> getByPostId(long id);

    CommentResponse convertToResponse(Comment comment);
//    Comment convertToEntity(CommentRequest commentRequest);
}
