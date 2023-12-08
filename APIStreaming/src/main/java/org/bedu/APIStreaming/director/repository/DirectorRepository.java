package org.bedu.APIStreaming.director.repository;

import org.bedu.APIStreaming.director.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository {

    public List<Director> findByLastName(String lastName);

    public List<Director> findByFirstName(String firstName);

}
