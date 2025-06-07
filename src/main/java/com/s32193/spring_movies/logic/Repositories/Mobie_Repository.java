package com.s32193.spring_movies.logic.Repositories;

import com.s32193.spring_movies.movies.Mobie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Mobie_Repository extends JpaRepository<Mobie, Integer> {
    Optional<Mobie> findById(int id);

    List<Mobie> findAll();

    void deleteById(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE mobie SET is_available = TRUE WHERE id= :id", nativeQuery = true)
    int updateAvailable(int id);


}
