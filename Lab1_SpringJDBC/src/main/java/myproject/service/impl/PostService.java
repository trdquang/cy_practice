package myproject.service.impl;

import myproject.dto.request.PostRequest;
import myproject.dto.response.PostResponse;
import myproject.dto.response.UserResponse;
import myproject.entity.Post;
import myproject.repository.impl.PostRepository;
import myproject.repository.impl.UserRepository;
import myproject.search.UserSearch;
import myproject.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentService commentService;

    @Override
    public List<PostResponse> getAll( ) {
        return postRepository.getAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public PostResponse convertToResponse(Post post) {
        return PostResponse.builder()
                .content(post.getPost_content())
                .commentResponseList(commentService.getByPostId(post.getId()))
                .build();
    }

    @Override
    public Post convertToPost(PostRequest postRequest) {
        return null;
    }
}
