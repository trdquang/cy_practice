package myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimePair {
    private Date start;
    private Date end;

    @Override
    public String toString() {
        return start.toString() + ", " + end.toString();
    }
}
