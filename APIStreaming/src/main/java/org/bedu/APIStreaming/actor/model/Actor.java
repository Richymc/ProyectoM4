package org.bedu.APIStreaming.actor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bedu.APIStreaming.person.Person;

@Getter
@Setter
@ToString
@Entity
@Table(name = "actors")
public class Actor extends Person{

}
