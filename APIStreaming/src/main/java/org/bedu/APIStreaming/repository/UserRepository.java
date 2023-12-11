package org.bedu.APIStreaming.repository;

import org.bedu.APIStreaming.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);

}