package com.s32193.spring_movies.logic.services;

import com.s32193.spring_movies.movies.Mobie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mobie_app_service {

    List<Mobie> mobies_list = new ArrayList<>();

    public ResponseEntity<Mobie> add_mobie(Mobie mobie){
        mobies_list.add(mobie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<Mobie> remove_mobie(int id){
        for (Mobie mobie : mobies_list) {
            if (mobie.getId() == id) {
                mobies_list.remove(mobie);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Mobie> get_by_id(int id) {
        for (Mobie mobie : mobies_list) {
            if (mobie.getId() == id) {
                return new ResponseEntity<>(mobie, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public List<Mobie> getMobies_list() {
        return mobies_list;
    }


    public void setMobies_list(List<Mobie> mobies_list) {
        this.mobies_list = mobies_list;
    }

    public ResponseEntity<Mobie> update_mobie(Mobie mobie, int id) {
        for (Mobie mobie1 : mobies_list) {
            if (mobie1.equals(mobie)) {
                mobie1.setId(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
