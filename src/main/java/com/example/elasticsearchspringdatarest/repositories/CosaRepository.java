package com.example.elasticsearchspringdatarest.repositories;

import com.example.elasticsearchspringdatarest.models.Cosa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cose", path = "cose")
public interface CosaRepository extends JpaRepository<Cosa, Long> {
}
