package com.s32193.spring_movies.logic.services;

import com.s32193.spring_movies.logic.Repositories.Mobie_Repository;
import com.s32193.spring_movies.movies.Mobie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class Mobie_app_service {

    Mobie_Repository mobie_repository;

    public Mobie_app_service(Mobie_Repository mobie_repository) {
        this.mobie_repository = mobie_repository;
    }

    public ResponseEntity<Mobie> add_mobie(Mobie mobie) {
        mobie_repository.save(mobie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Mobie> remove_mobie(int id) {
        Optional<Mobie> mobie = mobie_repository.findById(id);
        if (mobie.isPresent()) {
            mobie_repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Mobie> get_by_id(int id) {
        Optional<Mobie> mobie = mobie_repository.findById(id);
        if (mobie.isPresent()) {
            return new ResponseEntity<>(mobie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public List<Mobie> getMobies_list() {
        return mobie_repository.findAll();
    }


    public ResponseEntity<Mobie> update_mobie(Mobie mobie, int id) {
        Optional<Mobie> mobie1 = mobie_repository.findById(id);
        if (mobie1.isPresent()) {
            if (mobie1.get().equals(mobie)) {
                return new ResponseEntity<>(mobie_repository.save(mobie), HttpStatus.OK);
            } else {
                mobie.setId(id);
                mobie_repository.save(mobie);
                return new ResponseEntity<>(mobie, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Mobie> update_avaiable(int id) {
        if (mobie_repository.updateAvailable(id) == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Mobie> rent_mobie(int id) {
        Optional<Mobie> mobie = mobie_repository.findById(id);
        if (mobie.isPresent()) {
            if (mobie.get().isAvailable()){
                mobie.get().setAvailable(false);
                return new ResponseEntity<>(mobie_repository.save(mobie.get()), HttpStatus.OK);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Mobie> return_mobie(int id) {
        Optional<Mobie> mobie = mobie_repository.findById(id);
        if (mobie.isPresent()) {
            mobie.get().setAvailable(true);
            return new ResponseEntity<>(mobie_repository.save(mobie.get()), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
