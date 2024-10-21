package myproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myproject.entity.TimePair;
import myproject.util.FunctionUtil;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {
    private int idRoom;
    private String name;
    private String address;
    private double price1;
    private double price2;
    private int idHotel;
    private String nameHotel;
    private String image;
    private int active;
    private Date createDate;
    private Date updateDate;
    private List<TimePair> timeCheckList;
//    private List

    public String toString() {
        String res = "";
        for(TimePair it: timeCheckList){
            res += it.getStart() + ", " + it.getEnd() + "\n";
        }
        return res;
    }
}
