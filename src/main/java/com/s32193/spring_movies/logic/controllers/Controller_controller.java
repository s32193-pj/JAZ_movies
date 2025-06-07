package com.s32193.spring_movies.logic.controllers;

import com.s32193.spring_movies.logic.services.Mobie_app_service;
import com.s32193.spring_movies.movies.Mobie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class Controller_controller {

    private final Mobie_app_service mobie_app_service;

    public Controller_controller(Mobie_app_service mobieAppService) {
        mobie_app_service = mobieAppService;
    }

    @GetMapping("all_movies")
    public ResponseEntity<List<Mobie>> get_all() {
        return ResponseEntity.ok(mobie_app_service.getMobies_list());
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<Mobie> get_by_id(@PathVariable int id) {
      return ResponseEntity.ok(mobie_app_service.get_by_id(id).getBody());
    }

    @PostMapping("movie/add_movie")
    public ResponseEntity<Mobie> add_movie(@RequestBody Mobie mobie) {
        return mobie_app_service.add_mobie(mobie);
    }

    @PutMapping("movie/{id}")
    public ResponseEntity<Mobie> update_mobie(@RequestBody Mobie mobie, @PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.update_mobie(mobie, id).getBody());
    }

    @DeleteMapping("movie/delete/{id}")
    public ResponseEntity<Mobie> delete_mobie(@PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.remove_mobie(id).getBody());
    }

    @GetMapping("movie/update_avaiable/{id}")
    public ResponseEntity<Mobie> make_avaiable(@PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.update_avaiable(id).getBody());
    }

    @GetMapping("movie/rent/{id}")
    public ResponseEntity<Mobie> make_rent(@PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.rent_mobie(id).getBody());
    }
    @GetMapping("movie/return/{id}")
    public ResponseEntity<Mobie> make_return(@PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.return_mobie(id).getBody());
    }

}
