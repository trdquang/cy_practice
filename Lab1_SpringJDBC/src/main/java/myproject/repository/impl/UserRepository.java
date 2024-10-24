package myproject.repository.impl;

import myproject.entity.User;
import myproject.repository.IUserRepository;
import myproject.search.UserSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    private  JdbcTemplate jbJdbcTemplate ;

    @Override
    public int count() {
        return jbJdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    }

    @Override
    public List<User> getAll(UserSearch userSearch) {

        User user = new User();
        return jbJdbcTemplate.query("select * from user",
                (rs, rowNum) ->
                    new User(rs.getLong("id"),
                            rs.getString("user_name"),
                            rs.getString("pass_word"),
                            rs.getString("full_name"),
                            rs.getString("avatar"),
                            rs.getInt("active"),
                            rs.getString("email"),
                            rs.getString("role")
                    )
        );
    }

    @Override
    public int add(User user) {
        return jbJdbcTemplate.update(
                "insert into user(user_name, pass_word, full_name)" +
                        " values (?, ?, ?)", user.getUsername(), user.getPassword(), user.getFullname());
    }

    @Override
    public int edit(User user) {
        return jbJdbcTemplate.update(
                "update user set user_name = ? where "+
                        " id = ?", user.getUsername(), user.getId());
    }

    @Override
    public User getById(Long id) {
        return null;
    }
}
