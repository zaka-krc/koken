package be.ehb.koken.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Cook {
    @Id
    private int id;
    private String naam;
    @OneToMany(mappedBy = "cook")
    private List<Recepe> recepten;

    public Cook() {
    }

    public Cook(int id, String naam) {
        this.id = id;
        this.naam = naam;
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
}
