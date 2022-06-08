package com.example.elasticsearchspringdatarest.models.elastic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;
import java.io.Serializable;

@Document(indexName = "cose")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CosaDocument implements Serializable {

    @Id
    private Long id;
    @Field(name = "nome_cosa")
    private String cosaName;
    private String description;
}
