package repository;

import entity.Category;
import search.CategorySearch;

import java.util.List;

public interface ICategoryRepository {
    List<Category> getAll(CategorySearch categorySearch);
    Category findById(int id);

    Category add(Category category);
    int edit(Category category);
    int delete(Category category);
}
