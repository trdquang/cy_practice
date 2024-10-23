package repository;

import entity.Product;
import search.ProductSearch;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll(ProductSearch productSearch);
    Product findById(int id);

    Product add(Product product);
    int edit(Product product);
    int delete(Product product);
}
