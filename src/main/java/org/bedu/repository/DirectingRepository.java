package org.bedu.repository;

import org.bedu.model.Directing;
import org.bedu.model.DirectingKey;
import org.bedu.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectingRepository extends JpaRepository<Directing, DirectingKey> {
    
    @Query("SELECT i.movie FROM Directing i WHERE i.director.id = :directorId")
    List<Movie> findMoviesByDirector(long directorId);



}
