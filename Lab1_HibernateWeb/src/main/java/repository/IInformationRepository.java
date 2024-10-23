package repository;

import entity.Information;
import entity.Product;
import search.InformationSearch;
import search.ProductSearch;

import java.util.List;

public interface IInformationRepository {
    List<Information> getAll(InformationSearch informationSearch);
}
