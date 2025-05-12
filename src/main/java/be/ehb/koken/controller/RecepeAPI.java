package be.ehb.koken.controller;

import be.ehb.koken.model.Cook;
import be.ehb.koken.model.DAO.CookDAO;
import be.ehb.koken.model.DAO.RecepeDAO;
import be.ehb.koken.model.Recepe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//zet een responsebody op de class
@RequestMapping("/recepe")//zet de mapping op de class
public class RecepeAPI {

    private CookDAO cookDAO;
    private RecepeDAO recepeDAO;

    @Autowired
    public RecepeAPI(CookDAO cookDAO, RecepeDAO recepeDAO) {
        this.cookDAO = cookDAO;
        this.recepeDAO = recepeDAO;
    }

    @PostMapping("/cook")
    public void addCook(@RequestParam int id, String naam){
        Cook cook = new Cook(id, naam);
        cookDAO.save(cook);
    }
    @PostMapping("/add") //We moeten een cook zoeken om het recept te maken
    public ResponseEntity<Recepe> addRecepe(@RequestParam int id, String naam, String description, int cookId){
        if (cookDAO.existsById(cookId)){
            Cook foundIt = cookDAO.findById(cookId).get();

            Recepe recepe = new Recepe(id, naam, description, foundIt);
            recepeDAO.save(recepe);
            return new ResponseEntity<>(recepe, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public Iterable<Recepe> getAllRecepes(){
        return recepeDAO.findAll();
    }

    @GetMapping("/{id}")
    public Cook getCookById(@PathVariable int id){
        return cookDAO.findById(id).get();

    }



}
