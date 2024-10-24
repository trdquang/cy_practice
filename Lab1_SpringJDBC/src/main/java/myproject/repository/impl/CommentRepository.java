package myproject.repository.impl;

import myproject.entity.Comment;
import myproject.entity.Post;
import myproject.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository implements ICommentRepository {
    @Autowired
    private JdbcTemplate jbJdbcTemplate ;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getAll() {
        return jbJdbcTemplate.query("select * from comment",
                (rs, rowNum) ->
                        new Comment(rs.getLong("id"),
                                rs.getString("comment_content"),

                                rs.getLong("user_id"),
                                rs.getLong("post_id")
                        )
        );
    }

    @Override
    public int add(Comment comment) {
        return 0;
    }

    @Override
    public int edit(Comment comment) {
        return 0;
    }

    @Override
    public Comment getById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from comment where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        new Comment(
                                rs.getLong("id"),
                                rs.getString("post_content"),
                                rs.getLong("user_id"),
                                rs.getLong("post_id")
                        )
        );
    }

    @Override
    public List<Comment> getByPostId(Long id) {
        return jbJdbcTemplate.query("select * from comment where  post_id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        new Comment(rs.getLong("id"),
                                rs.getString("comment_content"),

                                rs.getLong("user_id"),
                                rs.getLong("post_id")
                        )
        );
    }
}
