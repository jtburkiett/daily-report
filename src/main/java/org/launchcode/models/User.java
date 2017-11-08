package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by JosephT on 7/27/2017.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private int uid;

    @NotNull
    @Size(min= 5, max= 15)
    private String username;

    @Email(message = "Invalid email address")
    private String email;

    @NotNull
    @Size(min=5, message = "Password must be at least 5 characters long")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {}

    public int getId() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null && verifyPassword != null
                && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
