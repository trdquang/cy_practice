package service.impl;

import dto.response.CategoryResp;
import dto.response.InformationResp;
import entity.Information;
import repository.IInformationRepository;
import repository.impl.InformationRepository;
import search.InformationSearch;
import service.ICategoryService;
import service.IInformationService;

import java.util.List;
import java.util.stream.Collectors;

public class InformationService implements IInformationService {
    private IInformationRepository informationRepository = new InformationRepository();

    @Override
    public List<InformationResp> getAll(InformationSearch informationSearch) {
        return informationRepository.getAll(new InformationSearch())
                .stream()
                .map(this::convertToRespone)
                .collect(Collectors.toList());
    }

    @Override
    public InformationResp convertToRespone(Information information) {
        return InformationResp.builder()
                .id(information.getId())
                .name_info(information.getName_info())
                .productId(information.getProduct().getId())
                .productName(information.getProduct().getName())
                .build();
    }

    @Override
    public List<InformationResp> convertToResponeList(List<Information> information) {
        return information.stream()
                .map(this::convertToRespone)
                .collect(Collectors.toList());
    }
}
