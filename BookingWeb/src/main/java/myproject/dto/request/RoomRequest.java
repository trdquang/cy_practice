package myproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {
    private int idRoom;
    private String name;
    private double price1;
    private double price2;
    private int idHotel;
    private String image;
    private int active;
}
