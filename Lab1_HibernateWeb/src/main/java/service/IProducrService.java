package service;

import dto.request.ProductRequest;
import dto.request.UserRequest;
import dto.response.ProductResp;
import dto.response.UserResp;
import entity.Product;
import entity.User;
import search.ProductSearch;
import search.UserSearch;

import java.util.List;

public interface IProducrService {
    List<ProductResp> getAll(ProductSearch productSearch);

    //-------------------------------
    int edit(ProductRequest productRequest);
    int deleteById (int id);

    //-------------------------------
    ProductResp convertToRespone(Product product);
    List<ProductResp> convertToListRespone(List<Product> products);
    Product convertToProduct(ProductRequest productRequest);

}
