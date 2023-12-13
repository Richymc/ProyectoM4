package org.bedu.APIStreaming.repository;

import org.bedu.APIStreaming.model.Actor;
import org.bedu.APIStreaming.model.Directing;
import org.bedu.APIStreaming.model.DirectingKey;
import org.bedu.APIStreaming.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectingRepository extends JpaRepository<Directing, DirectingKey> {
    
    @Query("SELECT i.movie FROM Directing i WHERE i.director.id = :directorId")
    List<Movie> findMoviesByDirector(long directorId);



}
