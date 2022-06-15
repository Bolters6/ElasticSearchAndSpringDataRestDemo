package com.example.elasticsearchspringdatarest.repositories;

import com.example.elasticsearchspringdatarest.models.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
}
