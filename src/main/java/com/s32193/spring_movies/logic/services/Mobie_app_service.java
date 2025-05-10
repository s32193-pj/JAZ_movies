package com.s32193.spring_movies.logic.services;

import com.s32193.spring_movies.logic.Repositories.Mobie_Repository;
import com.s32193.spring_movies.movies.Mobie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mobie_app_service {

    Mobie_Repository mobie_repository;

    public Mobie_app_service(Mobie_Repository mobie_repository) {
        this.mobie_repository = mobie_repository;
    }

    public ResponseEntity<Mobie> add_mobie(Mobie mobie){
        mobie_repository.save(mobie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<Mobie> remove_mobie(int id){
        for (Mobie mobie : mobie_repository.findAll()) {
            if (mobie.getId() == id) {
                mobie_repository.delete(mobie);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Mobie> get_by_id(int id) {
        for (Mobie mobie : mobie_repository.findAll()) {
            if (mobie.getId() == id) {
                return new ResponseEntity<>(mobie, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public List<Mobie> getMobies_list() {
        return mobie_repository.findAll();
    }


    public ResponseEntity<Mobie> update_mobie(Mobie mobie, int id) {
        for (Mobie mobie1 : mobie_repository.findAll()) {
            if (mobie1.equals(mobie)) {
                mobie1.setId(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
