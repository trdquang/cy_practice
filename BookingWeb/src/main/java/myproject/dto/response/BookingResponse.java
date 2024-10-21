package myproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private int idBooking;
    private int idUser;
    private int idRoom;
    private String roomName;
    private Date timeCheckin;
    private Date timeCheckout;
    private Double price;
    private String staus;
}
