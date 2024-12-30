package com.example.commandeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.commandeservice.entitie.Commande;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande,Long> {

}
