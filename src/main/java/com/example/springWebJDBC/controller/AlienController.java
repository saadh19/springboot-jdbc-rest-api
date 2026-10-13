package com.example.springWebJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springWebJDBC.model.Alien;
import com.example.springWebJDBC.service.AlienService;

@RestController 
public class AlienController {

    private final AlienService as;
    @Autowired 
    public AlienController(AlienService as) {
        this.as = as;
    }
    
    
    @GetMapping("/aliens") 
    public List<Alien> getAlien(){
        List<Alien> aliens = as.getAlien();
        return aliens;
    }

    @GetMapping("/aliens/{id}")
    public Alien getOneAlien(@PathVariable int id){
        Alien a = as.getOneAlien(id);
        return a;
    }

    @PostMapping("/postalien")
    public String createAlien(@RequestBody Alien a){
        if(as.createAlien(a)!=0)
            return "Created Record";
        return "Not Created";
    }

    @PutMapping("/upalien")
    public String updateAlien(@RequestBody Alien a){
        if(as.updateAlien(a)!=0)
            return "Updated";
        return "Not Updated";
    }

    @DeleteMapping("/dalien/{id}")
    public String deleteAlien(@PathVariable int id){
        if(as.deleteAlien(id)!=0)
            return "Deleted";
        return "Not Deleted";
    }

}
