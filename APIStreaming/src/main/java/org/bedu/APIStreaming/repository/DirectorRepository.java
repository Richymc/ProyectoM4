package org.bedu.APIStreaming.repository;

import org.bedu.APIStreaming.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    public List<Director> findByLastName(String lastName);

    public List<Director> findByFirstName(String firstName);

}
