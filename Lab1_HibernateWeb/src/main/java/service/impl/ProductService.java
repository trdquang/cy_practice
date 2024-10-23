package service.impl;

import dto.request.ProductRequest;
import dto.response.ProductResp;
import entity.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import search.ProductSearch;
import search.UserSearch;
import service.IProducrService;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProducrService {
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<ProductResp> getAll(ProductSearch productSearch) {
        return productRepository.getAll(productSearch).stream()
                .map(this::convertToRespone)
                .collect(Collectors.toList());
    }


    @Override
    public int edit(ProductRequest productRequest) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    //--------------------------------------------------------------------
    @Override
    public ProductResp convertToRespone(Product product) {
        return ProductResp.builder()
                .id(product.getId())
                .name(product.getName())
                .idCategory(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .build();
    }

    @Override
    public List<ProductResp> convertToListRespone(List<Product> products) {
        return products.stream()
                .map(this::convertToRespone)
                .collect(Collectors.toList());
    }

    @Override
    public Product convertToProduct(ProductRequest productRequest) {
        return null;
    }

}
