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

    public void add_mobie(Mobie mobie){
        mobies_list.add(mobie);
    }
    public void remove_mobie(Mobie mobie){
        mobies_list.remove(mobie);
    }

    public Mobie get_by_id(int id){
        for(Mobie mobie: mobies_list){
            if(mobie.getId() == id){
                return mobie;
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
}
