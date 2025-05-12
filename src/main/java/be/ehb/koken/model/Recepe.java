package be.ehb.koken.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recepe {
    @Id
    private int id;
    private String naam;
    private String description;
    @ManyToOne
    @JoinColumn(name = "recepe_id")
    private Cook cook;

    public Recepe() {
    }

    public Recepe(int id, String naam, String description, Cook cook) {
        this.id = id;
        this.naam = naam;
        this.description = description;
        this.cook = cook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
