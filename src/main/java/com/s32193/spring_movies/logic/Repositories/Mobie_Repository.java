package com.s32193.spring_movies.logic.Repositories;

import com.s32193.spring_movies.movies.Mobie;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Mobie_Repository implements JpaRepository<Mobie, Integer> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Mobie> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Mobie> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Mobie> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Mobie getOne(Integer integer) {
        return null;
    }

    @Override
    public Mobie getById(Integer integer) {
        return null;
    }

    @Override
    public Mobie getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Mobie> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Mobie> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Mobie> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Mobie> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Mobie> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Mobie> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Mobie, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Mobie> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Mobie> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Mobie> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Mobie> findAll() {
        return List.of();
    }

    @Override
    public List<Mobie> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Mobie entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Mobie> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Mobie> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Mobie> findAll(Pageable pageable) {
        return null;
    }
}
