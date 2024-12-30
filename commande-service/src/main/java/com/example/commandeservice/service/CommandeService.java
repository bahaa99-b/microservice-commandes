package com.example.commandeservice.service;

import com.example.commandeservice.entitie.Commande;
import com.example.commandeservice.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    // Récupérer toutes les commandes
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    // Ajouter une nouvelle commande
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    // Trouver une commande par ID
    public Commande findById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    // Supprimer une commande par ID
    public void deleteById(Long id) {
        commandeRepository.deleteById(id);
    }
}
