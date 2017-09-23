package ru.kpfu.itis.sharipova.model;

import javax.persistence.*;

/**
 * Created by lia on 07.05.16.
 */
@Entity
@Table(name = "admins", schema = "public", catalog = "hotel_db")
public class Admin {
    private Long id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admins_gen")
    @SequenceGenerator(sequenceName = "admins_id_seq", name = "admins_gen", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    private Credentials credentials;

    @OneToOne
    @JoinColumn(name = "credentials_id", referencedColumnName = "id")
    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin that = (Admin) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
