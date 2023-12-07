package org.bedu.APIStreaming.actor.repository;

import org.bedu.APIStreaming.actor.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    public List<Actor> findByLastName(String lastName);

    public List<Actor> findByFirstName(String firstName);

}
