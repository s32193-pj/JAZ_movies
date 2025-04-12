package com.s32193.spring_movies.logic.controllers;

import com.s32193.spring_movies.logic.services.Mobie_app_service;
import com.s32193.spring_movies.movies.Mobie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
      return ResponseEntity.ok(mobie_app_service.getMobies_list().get(id));
    }


}
