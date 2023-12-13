package org.bedu.APIStreaming.repository;

import org.bedu.APIStreaming.model.Actor;
import org.bedu.APIStreaming.model.Movie;
import org.bedu.APIStreaming.model.Performance;
import org.bedu.APIStreaming.model.PerformanceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, PerformanceKey> {
    
    @Query("SELECT i.movie FROM Performance i WHERE i.actor.id = :actorId")
    List<Movie> findMoviesByActor(long actorId);


    @Query("SELECT i.actor FROM Performance i WHERE i.movie.id = :movieId")
    List<Actor> findActorsByMovie(long movieId);
}
