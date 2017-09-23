package ru.kpfu.itis.sharipova.model;

import javax.persistence.*;

/**
 * Created by lia on 07.05.16.
 */
@Entity
@Table(name = "photos", schema = "public", catalog = "hotel_db")
public class Photo {
    private Long id;
    private String path;

    private RoomType roomType;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photos_gen")
    @SequenceGenerator(sequenceName = "photos_id_seq", name = "photos_gen", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (id != null ? !id.equals(photo.id) : photo.id != null) return false;
        if (path != null ? !path.equals(photo.path) : photo.path != null) return false;
        return roomType != null ? roomType.equals(photo.roomType) : photo.roomType == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        return result;
    }
}
