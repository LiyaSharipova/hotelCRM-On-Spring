package ru.kpfu.itis.sharipova.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by lia on 14.05.16.
 */
public class RoomSearchForm {
    @NotNull(message = "fill in check in date")
    @NotEmpty(message = "fill in check in date")
    private String checkIn;

    @NotNull(message = "fill in check in date")
    @NotEmpty(message = "fill in check out date")
    private String checkOut;

    private Integer adults;
    private Integer kids;

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getKids() {
        return kids;
    }

    public void setKids(Integer kids) {
        this.kids = kids;
    }
}
