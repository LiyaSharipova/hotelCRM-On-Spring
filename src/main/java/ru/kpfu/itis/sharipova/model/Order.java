package ru.kpfu.itis.sharipova.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lia on 30.05.16.
 */
@Entity
@Table(name = "orders", schema = "public", catalog = "hotel_db")
public class Order {
    private Long id;
    private Date checkIn;
    private Date checkOut;
    private double totalPrice;
    private Room room;
    private HotelAdmin hotelAdmin;
    private Guest guest;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_gen")
    @SequenceGenerator(sequenceName = "orders_id_seq", name = "orders_gen", allocationSize = 1)
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

    @Basic
    @Column(name = "total_price")
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_admin_id", referencedColumnName = "id")
    public HotelAdmin getHotelAdmin() {
        return hotelAdmin;
    }

    public void setHotelAdmin(HotelAdmin hotelAdmin) {
        this.hotelAdmin = hotelAdmin;
    }

    @ManyToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order that = (Order) o;

        if (Double.compare(that.totalPrice, totalPrice) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (checkIn != null ? !checkIn.equals(that.checkIn) : that.checkIn != null) return false;
        if (checkOut != null ? !checkOut.equals(that.checkOut) : that.checkOut != null) return false;

        return true;
    }

    public Order() {
    }

    public Order(Date checkIn, Date checkOut, double totalPrice, Room room, HotelAdmin hotelAdmin, Guest guest) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
        this.room = room;
        this.hotelAdmin = hotelAdmin;
        this.guest = guest;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (checkIn != null ? checkIn.hashCode() : 0);
        result = 31 * result + (checkOut != null ? checkOut.hashCode() : 0);
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
