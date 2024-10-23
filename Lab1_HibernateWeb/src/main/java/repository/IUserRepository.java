package repository;

import entity.User;
import search.UserSearch;

import java.util.List;

public interface IUserRepository {
    List<User> getAll(UserSearch userSearch);
    Long getTotalPage(UserSearch userSearch);

    User findById(int id);

    User add(User user);
    int edit(User user);
    int delete(User user);
}
