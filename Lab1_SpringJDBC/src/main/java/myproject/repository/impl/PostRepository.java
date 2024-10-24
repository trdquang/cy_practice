package myproject.repository.impl;

import myproject.entity.Post;
import myproject.entity.User;
import myproject.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository implements IPostRepository {
    @Autowired
    private JdbcTemplate jbJdbcTemplate ;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Post> getAll() {
        return jbJdbcTemplate.query("select * from post",
                (rs, rowNum) ->
                        new Post(rs.getLong("id"),
                                rs.getString("post_content"),
                                rs.getLong("user_id")
                        )
        );
    }

    @Override
    public int add(Post post) {
        return 0;
    }

    @Override
    public int edit(Post post) {
        return 0;
    }

    @Override
    public Post getById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from post where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        new Post(
                                rs.getLong("id"),
                                rs.getString("post_content"),
                                rs.getLong("user_id")
                        )
        );
    }
}
