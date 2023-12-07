package org.bedu.APIStreaming.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bedu.APIStreaming.person.Person;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User extends Person {

    @Column(length = 100, nullable = false)
    private String email;

}