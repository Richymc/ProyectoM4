package org.bedu.APIStreaming.movie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "movies")
public class Movie {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;

    @Column ( length = 150, nullable = false)
    private String nameMovie;

    @Column
    private Long duration;

    @Column
    private String description;

    @Column
    private String genre;
}
