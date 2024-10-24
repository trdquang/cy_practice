package myproject.repository;

import myproject.entity.Post;
import myproject.entity.User;
import myproject.search.UserSearch;

import java.util.List;

public interface IPostRepository {
    List<Post> getAll();
    int add(Post post);
    int edit (Post post);
    Post getById(Long id);
}
