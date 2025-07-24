package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Data
public class User {

    @Setter
    private int id;
    private String firstName;
    private String lastName;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id && Objects.equals(firstName,user.getFirstName()) && Objects.equals(lastName,user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
