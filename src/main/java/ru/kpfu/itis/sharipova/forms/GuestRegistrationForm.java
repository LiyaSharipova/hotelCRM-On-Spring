package ru.kpfu.itis.sharipova.forms;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by lia on 07.05.16.
 */
public class GuestRegistrationForm {
    @Size(min = 1, max = 50, message = "name is too long")
    private String name;


    @Size(min = 2, max = 50, message = "login is too short or too long")
    private String login;

    @Size(min = 6, max = 32, message = "password must be 6-16 symbols long")
    private String password;

    private String repassword;

    @Email(regexp = ".+@.+", message = "wrong email")
    private String email;

    @NotEmpty(message = "fill in this field")
    @Size(min = 5, max = 25, message = "wrong phone number")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
