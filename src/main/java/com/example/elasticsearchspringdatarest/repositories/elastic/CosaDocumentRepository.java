package com.example.elasticsearchspringdatarest.repositories.elastic;


import com.example.elasticsearchspringdatarest.models.elastic.CosaDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



public interface CosaDocumentRepository extends ElasticsearchRepository<CosaDocument, Long> {
    Page<CosaDocument> findByCosaName(String name, Pageable pageable);
}
