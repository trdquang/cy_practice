package myproject.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myproject.entity.TimePair;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomSearch {
    private int page;
    private String location;
    private TimePair timePair;
}
