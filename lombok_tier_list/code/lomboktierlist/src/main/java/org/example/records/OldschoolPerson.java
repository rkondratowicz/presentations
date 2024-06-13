package org.example.records;

import java.util.Objects;

// 😭
public class OldschoolPerson {

    private String firstName;
    private String lastName;
    private String favouriteFood;
    private String hobby;

    public OldschoolPerson(String firstName, String lastName, String favouriteFood, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favouriteFood = favouriteFood;
        this.hobby = hobby;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldschoolPerson oldschoolPerson = (OldschoolPerson) o;
        return Objects.equals(firstName, oldschoolPerson.firstName) && Objects.equals(lastName, oldschoolPerson.lastName) && Objects.equals(favouriteFood, oldschoolPerson.favouriteFood) && Objects.equals(hobby, oldschoolPerson.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, favouriteFood, hobby);
    }
}
