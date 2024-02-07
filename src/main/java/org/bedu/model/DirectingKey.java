package org.bedu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DirectingKey {
    
    @Column(name = "movie_id")
    private long movieId;

    @Column(name = "director_id")
    private long directorId;
}
