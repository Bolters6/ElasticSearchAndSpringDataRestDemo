package com.example.elasticsearchspringdatarest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private TipoPersonaggio tipoPersonaggio;

    @OneToMany(mappedBy = "tipo", orphanRemoval = true, cascade = CascadeType.REMOVE, targetEntity = Personaggio.class)
    @JsonIgnore
    private Set<Personaggio> personaggi;

    private String description;
}
