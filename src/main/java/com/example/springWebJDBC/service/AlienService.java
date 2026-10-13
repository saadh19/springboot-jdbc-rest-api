package com.example.springWebJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.springWebJDBC.model.Alien;

@Service
public class AlienService {

    private final JdbcTemplate template;

    @Autowired 
    public AlienService(JdbcTemplate template) {
        this.template = template;
    }

    public List<Alien> getAlien(){
        String sql="SELECT * FROM Alien";
        List<Alien> aliens = template.query(sql, (rs, row) -> {
            
            Alien a =new Alien();
            a.setId(rs.getInt(1));
            a.setName(rs.getString(2));
            a.setTech(rs.getString(3));

            return a;
            });

        return aliens;
    }

    public int createAlien(Alien a){
        String sql = "INSERT INTO Alien(id, name, tech) VALUES(?,?,?)";
        int rowsAffected = template.update(sql, a.getId(), a.getName(), a.getTech());
        return rowsAffected;
    }

    public Alien getOneAlien(int id) {
        String sql = "SELECT * FROM Alien WHERE id ="+id;
        Alien alien = template.queryForObject(sql, (rs,row) -> {
            Alien a = new Alien();
            a.setId(rs.getInt(1));
            a.setName(rs.getString(2));
            a.setTech(rs.getString(3));
            return a;
        });
        return alien;
    }

    public int updateAlien(Alien a) {

        String sql = "UPDATE Alien SET tech = ? WHERE id = ?";
        int rowsAffected = template.update(sql, a.getTech(), a.getId() );

        return rowsAffected;
    }

    public int deleteAlien(int id) {
        String sql = "DELETE FROM Alien WHERE id = ?";
        int rowsAffected = template.update(sql, id);
        return rowsAffected;
    }
}
