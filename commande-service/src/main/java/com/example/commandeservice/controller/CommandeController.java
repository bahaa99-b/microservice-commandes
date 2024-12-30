package com.example.commandeservice.controller;

import com.example.commandeservice.entitie.Commande;
import com.example.commandeservice.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    // Endpoint pour récupérer toutes les commandes
    @GetMapping("/")
    public List<Commande> getAllCommandes() {
        return commandeService.findAll();
    }

    // Endpoint pour ajouter une nouvelle commande
    @PostMapping("/")
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    // Endpoint pour trouver une commande par ID
    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.findById(id);
    }

    // Endpoint pour supprimer une commande par ID
    @DeleteMapping("/{id}")
    public String deleteCommande(@PathVariable Long id) {
        commandeService.deleteById(id);
        return "Commande supprimée avec succès.";
    }
}
