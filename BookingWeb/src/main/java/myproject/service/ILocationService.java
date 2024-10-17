package myproject.service;

import myproject.dto.response.LocationResponse;

import java.util.List;

public interface ILocationService {
    List<LocationResponse> getAllProvince();
    List<LocationResponse> getAllDistrictByProvince(int idProvince);
    List<LocationResponse> getAllCommueByDistrict(int idDistrict);
    String getNameById(int id);
}
