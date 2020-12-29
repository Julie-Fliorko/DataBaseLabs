package com.example.domain;
import javax.persistence.*;

@Table(name="country")
@Entity
public class Country {

    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Override
    public String toString() {
        return "Country_______________________________________________"+ "\n"+
                "name='" + name + "\n"+
                "id=" + id + "\n"+
                "_____________________________________________________"+ "\n";
    }


    public Country(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
