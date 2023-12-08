package org.bedu.APIStreaming.director.repository;

import org.bedu.APIStreaming.director.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository {

    public List<Director> findByLastName(String lastName);

    public List<Director> findByFirstName(String firstName);

}
