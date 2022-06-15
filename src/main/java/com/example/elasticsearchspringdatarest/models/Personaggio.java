package com.example.elasticsearchspringdatarest.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(name = "email", columnNames = "email"))
public class Personaggio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, targetEntity = Cosa.class)
    @JoinColumn(name = "personaggio_id")
    private Set<Cosa> cose;
    @ManyToOne(targetEntity = Tipo.class, optional = false)
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    private Tipo tipo;
}
