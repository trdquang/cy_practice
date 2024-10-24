package myproject.repository;

import myproject.entity.User;
import myproject.search.UserSearch;

import java.util.List;

public interface IUserRepository {
    int count();
    List<User> getAll(UserSearch userSearch);
    int add(User user);
    int edit (User user);
    User getById(Long id);
}
