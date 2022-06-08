package com.example.elasticsearchspringdatarest.controllers;

import com.example.elasticsearchspringdatarest.models.Cosa;
import com.example.elasticsearchspringdatarest.models.Utente;
import com.example.elasticsearchspringdatarest.models.elastic.CosaDocument;
import com.example.elasticsearchspringdatarest.repositories.CosaRepository;
import com.example.elasticsearchspringdatarest.repositories.UtenteRepository;
import com.example.elasticsearchspringdatarest.repositories.elastic.CosaDocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@Transactional
@RequestMapping(path = "/actions")
public class UtenteCosaActions {

    private final CosaDocumentRepository cosaDocumentRepository;
    private final UtenteRepository utenteRepository;
    private final CosaRepository cosaRepository;

    @PostMapping(path = "/setcosa")
    public ResponseEntity<?> setCosaToUtente(@RequestParam Long idUtente, @RequestParam Long idCosa){
        utenteRepository.findById(idUtente).ifPresentOrElse(
                utente -> cosaRepository.findById(idCosa).ifPresentOrElse(
                        cosa -> {utente.getCose().add(cosa);
                            cosaDocumentRepository.save(CosaDocument.builder()
                                    .cosaName(cosa.getCosaName())
                                    .description(cosa.getDescription())
                                    .id(cosa.getId()).build());
                        }, () -> log.error("Cosa Non Esistente")
                ), () -> log.error("Utente Non Esistente")
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(path = "/postutente")
    public ResponseEntity<Utente> addUtente(@RequestBody Utente utente){
        return ResponseEntity.status(HttpStatus.CREATED).body(utenteRepository.save(utente));
    }

    @PostMapping(path = "/postcosa")
    public ResponseEntity<Cosa> addUtente(@RequestBody Cosa cosa){
        return ResponseEntity.status(HttpStatus.CREATED).body(cosaRepository.save(cosa));
    }

    @PostMapping(path = "/{id}/enrollcosa")
    public ResponseEntity<?> enrollCosa(@PathVariable Long id, @RequestBody Cosa cosa){
        utenteRepository.findById(id).ifPresentOrElse(utente -> {cosaRepository.save(cosa); utente.getCose().add(cosa);}, () -> log.error("Utente Non Esiste"));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/getutente/{id}")
    public ResponseEntity<Utente> getUtente(@PathVariable Long id){
        Optional<Utente> utente = utenteRepository.findById(id);
        if(utente.isEmpty()){
            log.error("Utente No Esiste");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(utente.get());
    }

    @GetMapping(path = "/getcosa/{id}")
    public ResponseEntity<Cosa> getCosa(@PathVariable Long id){
        Optional<Cosa> cosa = cosaRepository.findById(id);
        if(cosa.isEmpty()){
            log.error("Cosa No Esiste");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(cosa.get());
    }

    @GetMapping(path = "/elastic/{name}")
    public ResponseEntity<?> elasticSearchCosa(@PathVariable String name){
        return ResponseEntity.ok().body(cosaDocumentRepository.findByCosaName(name, Pageable.ofSize(5)));
    }
}
