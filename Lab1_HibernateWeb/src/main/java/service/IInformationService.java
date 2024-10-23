package service;

import dto.request.CategoryRequest;
import dto.response.CategoryResp;
import dto.response.InformationResp;
import entity.Category;
import entity.Information;
import search.CategorySearch;
import search.InformationSearch;

import java.util.List;

public interface IInformationService {
    List<InformationResp> getAll(InformationSearch informationSearch);


//    int edit(CategoryRequest categoryReq);
//    int deleteById (int id);

    //--------------convert
    InformationResp convertToRespone(Information information);
    List <InformationResp> convertToResponeList(List<Information> information);
//    Category convertToCategory(CategoryRequest categoryReq);
}
