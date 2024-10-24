package myproject.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private long id;
    private String comment_content;

    private long user_id;
    private long post_id;
}
