package service;

import dto.request.CategoryRequest;
import dto.response.CategoryResp;
import entity.Category;
import search.CategorySearch;

import java.util.List;

public interface ICategoryService {
    List<CategoryResp> getAll(CategorySearch categorySearch);


    int edit(CategoryRequest categoryReq);
    int deleteById (int id);

    //--------------convert
    CategoryResp convertToRespone(Category category);
    Category convertToCategory(CategoryRequest categoryReq);
}
