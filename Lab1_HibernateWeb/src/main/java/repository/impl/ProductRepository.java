package repository.impl;

import entity.Product;
import org.hibernate.Session;
import repository.IProductRepository;
import search.ProductSearch;
import util.HibernateUtils;

import java.util.List;

public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> getAll(ProductSearch productSearch) {
//        Session session = null;

        try (Session session =HibernateUtils.getSessionFactory().openSession()){
            List<Product> productList = session.createQuery("FROM Product ", Product.class).list();
            return productList;
        }catch (Exception e){
            System.out.println("err when search product: " + e);
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Product add(Product product) {
        return null;
    }

    @Override
    public int edit(Product product) {
        return 0;
    }

    @Override
    public int delete(Product product) {
        return 0;
    }
}
