package com.s32193.spring_movies.logic.controllers;

import com.s32193.spring_movies.logic.services.Mobie_app_service;
import com.s32193.spring_movies.movies.Mobie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.annotations.Comment;
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
    @Tag(name = "lista filmow")
    @Operation(
            summary = "Zwraca liste wszystkich filmow",
            description = "wysyla zapytanie GET do serwisu, ktory potem wykonuje żadaną operacje"
    )
    @ApiResponse(
            responseCode = "200",
            description = "zapytanie pomyslnie otrzymalo tresc zwrotna, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "404",
            description = "zapytanie otrzymalo tresc zwrotna: brak filmu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "400",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, z powodu zle sformulowanego requestu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "500",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, aplikacja nie dziala zgodnie z zamierzeniem"
    )
    public ResponseEntity<List<Mobie>> get_all() {
        return ResponseEntity.ok(mobie_app_service.getMobies_list());
    }

    @GetMapping("movie/{id}")
    @Tag(name = "wyszukanie filmu")
    @Operation(
            summary = "wyszukuje film po id",
            description = "otrzymuje int(id) i wysyla zapytanie do serwisu ktory potem wykonuje dalsze operacje"
    )
    @ApiResponse(
            responseCode = "200",
            description = "zapytanie pomyslnie otrzymalo tresc zwrotna, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "404",
            description = "zapytanie otrzymalo tresc zwrotna: brak filmu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "400",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, z powodu zle sformulowanego requestu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "500",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, aplikacja nie dziala zgodnie z zamierzeniem"
    )
    public ResponseEntity<Mobie> get_by_id(@PathVariable int id) {
      return ResponseEntity.ok(mobie_app_service.get_by_id(id).getBody());
    }

    @PostMapping("movie/add_movie")
    @Tag(name = "dodanie filmu")
    @Operation(
            summary = "dodaje film",
            description = "przyjmuje body o typie Mobie, oraz przesyla je do serwisu"
    )
    @ApiResponse(
            responseCode = "200",
            description = "zapytanie pomyslnie otrzymalo tresc zwrotna, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "400",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, z powodu zle sformulowanego requestu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "500",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, aplikacja nie dziala zgodnie z zamierzeniem"
    )
    public ResponseEntity<Mobie> add_movie(@RequestBody Mobie mobie) {
        return mobie_app_service.add_mobie(mobie);
    }

    @PutMapping("movie/{id}")
    @Tag(name = "update'owanie filmu")
    @Operation(
            summary = "dokonuje update filmu",
            description = "przyjmuje body w postaci Mobie, oraz int(id), oraz przekazuje je do serwisu w celu wykonania dalszych operacji"
    )
    @ApiResponse(
            responseCode = "200",
            description = "zapytanie pomyslnie otrzymalo tresc zwrotna, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "404",
            description = "zapytanie otrzymalo tresc zwrotna: brak filmu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "400",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, z powodu zle sformulowanego requestu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "500",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, aplikacja nie dziala zgodnie z zamierzeniem"
    )
    public ResponseEntity<Mobie> update_mobie(@RequestBody Mobie mobie, @PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.update_mobie(mobie, id).getBody());
    }

    @DeleteMapping("movie/delete/{id}")
    @Tag(name = "usuwanie filmu")
    @Operation(
            summary = "usuwa film",
            description = "przyjmuje int(id), oraz przekazuje do serwisu w celu wykonania dalszych operacji"
    )
    @ApiResponse(
            responseCode = "200",
            description = "zapytanie pomyslnie otrzymalo tresc zwrotna, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "404",
            description = "zapytanie otrzymalo tresc zwrotna: brak filmu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "400",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, z powodu zle sformulowanego requestu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "500",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, aplikacja nie dziala zgodnie z zamierzeniem"
    )
    public ResponseEntity<Mobie> delete_mobie(@PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.remove_mobie(id).getBody());
    }

    @GetMapping("movie/update_avaiable/{id}")
    @Tag(name = "zmiana dostepnosci filmu")
    @Comment(value = "obecnie zwraca blad 500 z powodu roznic w bazie danych")
    @Operation(
            summary = "zmienia status dostepnosci filmu na True",
            description = "przyjmuje int(id) oraz przekazuje do serwisu w celu wykonania dalszych operacji"
    )
    @ApiResponse(
            responseCode = "200",
            description = "zapytanie pomyslnie otrzymalo tresc zwrotna, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "404",
            description = "zapytanie otrzymalo tresc zwrotna: brak filmu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "400",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, z powodu zle sformulowanego requestu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "500",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, aplikacja nie dziala zgodnie z zamierzeniem"
    )
    public ResponseEntity<Mobie> make_avaiable(@PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.update_avaiable(id).getBody());
    }

    @GetMapping("movie/rent/{id}")
    @Tag(name = "wypozyczenie filmu")
    @Operation(
            summary = "przyjmuje int(id) oraz przekazuje do serwisu w celu wykonania dalszych operacji"
    )
    @ApiResponse(
            responseCode = "200",
            description = "zapytanie pomyslnie otrzymalo tresc zwrotna, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "404",
            description = "zapytanie otrzymalo tresc zwrotna: brak filmu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "400",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, z powodu zle sformulowanego requestu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "500",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, aplikacja nie dziala zgodnie z zamierzeniem"
    )
    public ResponseEntity<Mobie> make_rent(@PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.rent_mobie(id).getBody());
    }
    @GetMapping("movie/return/{id}")
    @Tag(name = "zwracanie filmu")
    @Operation(
            summary = "zwraca film",
            description = "przyjmuje int id i przekazuje do serwisu w celu wykonania dalszych operacji"
    )
    @ApiResponse(
            responseCode = "200",
            description = "zapytanie pomyslnie otrzymalo tresc zwrotna, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "404",
            description = "zapytanie otrzymalo tresc zwrotna: brak filmu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "400",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, z powodu zle sformulowanego requestu, aplikacja dziala zgodnie z zamierzeniem"
    )
    @ApiResponse(
            responseCode = "500",
            description = "zapytanie otrzymalo blad jako tresc zwrotna, aplikacja nie dziala zgodnie z zamierzeniem"
    )
    public ResponseEntity<Mobie> make_return(@PathVariable int id) {
        return ResponseEntity.ok(mobie_app_service.return_mobie(id).getBody());
    }

}
