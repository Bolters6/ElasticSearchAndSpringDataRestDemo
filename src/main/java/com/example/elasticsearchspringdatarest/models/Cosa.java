package com.example.elasticsearchspringdatarest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cosa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cosaName;
    private String description;
    @ManyToOne
    @JoinTable(name = "utente_cose", joinColumns = @JoinColumn(name = "cose_id"), inverseJoinColumns = @JoinColumn(name = "utente_id"))
    @ToString.Exclude
    @JsonIgnore
    private Utente utente;
}
