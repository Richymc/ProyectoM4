package org.bedu.APIStreaming.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "directings")
public class Directing {
    
    @EmbeddedId
    private DirectingKey id;

    @ManyToOne
    @MapsId("directorId")
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
