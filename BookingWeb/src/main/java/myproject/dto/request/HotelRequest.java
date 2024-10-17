package myproject.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequest {
    private int idHotel;
    private String nameHotel;
    private String address;
    private String image;

    @Override
    public String toString() {
        String res = String.format("id: %-5d. name: %-15s, address: %-15s, image: %-15s",
                idHotel, nameHotel,address, image);
        return res;
    }
}
