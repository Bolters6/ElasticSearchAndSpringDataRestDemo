package com.example.elasticsearchspringdatarest.config;

import com.example.elasticsearchspringdatarest.models.Tipo;
import com.example.elasticsearchspringdatarest.models.TipoPersonaggio;
import com.example.elasticsearchspringdatarest.repositories.TipoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TipiPersonaggiConfig {

    @Bean
    CommandLineRunner commandLineRunner(TipoRepository tipoRepository){
        return args -> {
            if(tipoRepository.findAll().isEmpty()){
                tipoRepository.saveAll(List.of(
                        Tipo.builder().tipoPersonaggio(TipoPersonaggio.KNIGHT).description("Powerful Warrior").build(),
                        Tipo.builder().tipoPersonaggio(TipoPersonaggio.WIZARD).description("Ability Wizard").build(),
                        Tipo.builder().tipoPersonaggio(TipoPersonaggio.ELF).description("Support Elf").build()));
            }
        };
    }
}
