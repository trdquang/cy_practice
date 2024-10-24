package myproject.repository;

import myproject.entity.Comment;
import myproject.entity.Post;

import java.util.List;

public interface ICommentRepository {
    List<Comment> getAll();
    int add(Comment comment);
    int edit (Comment comment);
    Comment getById(Long id);
    List<Comment> getByPostId(Long id);
}
