package com.example.commandeservice.entitie;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity @Builder

public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int quantite;
    private LocalDate date;
    private Double montant;
}
