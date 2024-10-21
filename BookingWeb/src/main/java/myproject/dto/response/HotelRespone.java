package myproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myproject.util.FunctionUtil;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HotelRespone {
    private int idHotel;
    private String nameHotel;
    private String nameAddress;
    private String image;
    private Date createDate;
    private Date updateDate;

    @Override
    public String toString() {
        String res = String.format("%-10s, %-10s", FunctionUtil.parseDateToString(createDate),
               updateDate.toString());
        return res;
    }
}
