package myproject.dto.pageable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myproject.dto.response.HotelRespone;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelPagable {
    int currentPage;
    int totalPage;
    private List<HotelRespone> hotelResponeList;
}
