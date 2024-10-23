package repository.impl;

import entity.Category;
import org.hibernate.Session;
import repository.ICategoryRepository;
import search.CategorySearch;
import util.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    @Override
    public List<Category> getAll(CategorySearch categorySearch) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();

            List<Category> categoryList =  session.createQuery("FROM Category ").list();
            return categoryList;
        }catch (Exception e){
            System.out.println("err when search category: " + e);
        }
        return new ArrayList<>();
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public Category add(Category category) {
        return null;
    }

    @Override
    public int edit(Category category) {
        return 0;
    }

    @Override
    public int delete(Category category) {
        return 0;
    }
}
