package myproject.dto.response;

import lombok.*;
import myproject.entity.Comment;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    long id;
    String content;
//    long user_id;
    List<CommentResponse> commentResponseList;
}
