package myproject.service;

import myproject.dto.request.PostRequest;
import myproject.dto.request.UserRequest;
import myproject.dto.response.PostResponse;
import myproject.dto.response.UserResponse;
import myproject.entity.Post;
import myproject.entity.User;
import myproject.repository.impl.PostRepository;
import myproject.search.UserSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPostService {
    List<PostResponse> getAll( );

    PostResponse convertToResponse(Post post);
    Post convertToPost(PostRequest postRequest);
}
