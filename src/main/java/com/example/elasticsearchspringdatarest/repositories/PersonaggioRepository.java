package com.example.elasticsearchspringdatarest.repositories;

import com.example.elasticsearchspringdatarest.models.Personaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource(collectionResourceRel = "utenti", path = "utenti")
public interface PersonaggioRepository extends JpaRepository<Personaggio, Long> {
    List<Personaggio> findByName(@Param("email") String email);
}
