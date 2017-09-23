package ru.kpfu.itis.sharipova.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by lia on 07.05.16.
 */
@Entity
@Table(name = "hotel_admins", schema = "public", catalog = "hotel_db")
public class HotelAdmin {
    private Long id;
    private String fio;
    private Date hireDate;
    private Date birthday;


    private Hotel hotel;


    private Credentials credentials;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_admins_gen")
    @SequenceGenerator(sequenceName = "hotel_admins_id_seq", name = "hotel_admins_gen", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fio")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "hire_date")
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @OneToOne
    @JoinColumn(name = "credentials_id", referencedColumnName = "id")
    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelAdmin that = (HotelAdmin) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
