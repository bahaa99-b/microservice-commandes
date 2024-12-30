package com.example.commandeservice.entitie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import com.example.commandeservice.repository.CommandeRepository;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Health health() {
        long count = commandeRepository.count();
        if (count > 0) {
            return Health.up().withDetail("Message", "Commandes existantes : " + count).build();
        } else {
            return Health.down().withDetail("Message", "Aucune commande trouvée").build();
        }
    }
}
