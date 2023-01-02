package com.myproject.mypet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Animal {
    @Id @GeneratedValue private Long id;
    private String name;
    private String type;
    private String age;
    private String NDJ;
    private String description;
    private String photo;

    public Animal() {
    }

    public Animal(Long id, String name, String type, String age, String NDJ, String description, String photo) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.NDJ = NDJ;
        this.description = description;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNDJ() {
        return NDJ;
    }

    public void setNDJ(String NDJ) {
        this.NDJ = NDJ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (!Objects.equals(id, animal.id)) return false;
        if (!Objects.equals(name, animal.name)) return false;
        if (!Objects.equals(type, animal.type)) return false;
        if (!Objects.equals(age, animal.age)) return false;
        if (!Objects.equals(NDJ, animal.NDJ)) return false;
        if (!Objects.equals(description, animal.description)) return false;
        return Objects.equals(photo, animal.photo);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (NDJ != null ? NDJ.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", NDJ='" + NDJ + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
