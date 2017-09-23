package ru.kpfu.itis.sharipova.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lia on 07.05.16.
 */
@Entity
@Table(name = "bookings", schema = "public", catalog = "hotel_db")
public class Booking {
    private Long id;
    private Date checkIn;
    private Date checkOut;
    private Room room;
    private Guest guest;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookings_gen")
    @SequenceGenerator(sequenceName = "bookings_id_seq", name = "bookings_gen", allocationSize = 1)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "check_in")
    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "check_out")
    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    @ManyToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking that = (Booking) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (checkIn != null ? !checkIn.equals(that.checkIn) : that.checkIn != null) return false;
        if (checkOut != null ? !checkOut.equals(that.checkOut) : that.checkOut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (checkIn != null ? checkIn.hashCode() : 0);
        result = 31 * result + (checkOut != null ? checkOut.hashCode() : 0);
        return result;
    }
}
