package org.bedu.APIStreaming.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User extends Person {

    @Column(length = 100, nullable = false)
    private String email;

}