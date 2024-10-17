package myproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myproject.entity.Address;
import myproject.entity.Room;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HotelRespone {
    private int idHotel;
    private String nameHotel;
    private String nameAddress;
    private String image;

}
