package service.impl;

import dto.request.CategoryRequest;
import dto.response.CategoryResp;
import entity.Category;
import repository.ICategoryRepository;
import repository.IProductRepository;
import repository.impl.CategoryRepository;
import repository.impl.ProductRepository;
import search.CategorySearch;
import service.ICategoryService;
import service.IProducrService;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService implements ICategoryService {
    private ICategoryRepository categoryRepository = new CategoryRepository();
    private IProducrService producrService = new ProductService();

    @Override
    public List<CategoryResp> getAll(CategorySearch categorySearch) {
        return categoryRepository.getAll(categorySearch).stream()
                .map(this::convertToRespone)
                .collect(Collectors.toList());
    }

    @Override
    public int edit(CategoryRequest categoryReq) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public CategoryResp convertToRespone(Category category) {
        return CategoryResp.builder()
                .id(category.getId())
                .name(category.getName())
                .productRespList(producrService.convertToListRespone(category.getProductList()))
                .build();
    }

    @Override
    public Category convertToCategory(CategoryRequest categoryReq) {
        return null;
    }
}
