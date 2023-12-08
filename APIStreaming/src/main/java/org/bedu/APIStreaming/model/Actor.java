package org.bedu.APIStreaming.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bedu.APIStreaming.model.Person;

@Getter
@Setter
@ToString
@Entity
@Table(name = "actors")
public class Actor extends Person{

}
