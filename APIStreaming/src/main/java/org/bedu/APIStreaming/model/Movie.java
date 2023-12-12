package org.bedu.APIStreaming.model;

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
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column ( length = 100, nullable = false)
    private String name;

    @Column
    private long duration;

    @Column (length = 200)
    private String description;

    @Column
    private String genre;
}
