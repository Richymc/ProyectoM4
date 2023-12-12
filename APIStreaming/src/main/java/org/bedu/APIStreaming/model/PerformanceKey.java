package org.bedu.APIStreaming.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PerformanceKey {
    
    @Column(name = "movie_id")
    private long movieId;

    @Column(name = "actor_id")
    private long actorId;
}
