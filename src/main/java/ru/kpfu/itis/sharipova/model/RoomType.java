package ru.kpfu.itis.sharipova.model;

import javax.persistence.*;

import ru.kpfu.itis.sharipova.model.enums.RoomClass;

import java.util.List;
import java.util.Set;

/**
 * Created by lia on 07.05.16.
 */
@Entity
@Table(name = "room_type", schema = "public", catalog = "hotel_db")
public class RoomType {
    private Long id;
    private double price;
    private Integer adults;
    private Integer kids;
    private RoomClass roomClass;
    private List<Photo> photos;
    private String title;
    private String description;
    private List<Room> rooms;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rooms_gen")
    @SequenceGenerator(sequenceName = "rooms_id_seq", name = "rooms_gen", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "adults")
    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @Basic
    @Column(name = "kids")
    public Integer getKids() {
        return kids;
    }

    public void setKids(Integer kids) {
        this.kids = kids;
    }

    @Basic
    @Column(name = "room_class")
    @Enumerated(EnumType.STRING)
    public RoomClass getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(RoomClass roomClass) {
        this.roomClass = roomClass;
    }
    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(targetEntity = Photo.class, mappedBy = "roomType", fetch = FetchType.EAGER)
    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @OneToMany(targetEntity = Room.class, mappedBy = "roomType", fetch = FetchType.EAGER)
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomType roomType = (RoomType) o;

        if (Double.compare(roomType.price, price) != 0) return false;
        if (id != null ? !id.equals(roomType.id) : roomType.id != null) return false;
        if (adults != null ? !adults.equals(roomType.adults) : roomType.adults != null) return false;
        if (kids != null ? !kids.equals(roomType.kids) : roomType.kids != null) return false;
        if (roomClass != roomType.roomClass) return false;
        if (photos != null ? !photos.equals(roomType.photos) : roomType.photos != null) return false;
        if (title != null ? !title.equals(roomType.title) : roomType.title != null) return false;
        if (description != null ? !description.equals(roomType.description) : roomType.description != null)
            return false;
        return rooms != null ? rooms.equals(roomType.rooms) : roomType.rooms == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (adults != null ? adults.hashCode() : 0);
        result = 31 * result + (kids != null ? kids.hashCode() : 0);
        result = 31 * result + (roomClass != null ? roomClass.hashCode() : 0);
        result = 31 * result + (photos != null ? photos.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
        return result;
    }
}