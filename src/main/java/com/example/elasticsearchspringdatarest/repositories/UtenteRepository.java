package com.example.elasticsearchspringdatarest.repositories;

import com.example.elasticsearchspringdatarest.models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource(collectionResourceRel = "utenti", path = "utenti")
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    List<Utente> findByName(@Param("email") String email);
}
