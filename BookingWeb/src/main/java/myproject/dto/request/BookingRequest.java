package myproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private int idBooking;
    private int idUser;
    private int idRoom;
    private Date timeCheckIn;
    private Date timeCheckout;
    private Double price;

}
