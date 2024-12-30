package com.example.commandeservice.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfig {

    // Read the custom property from application.yml
    @Value("${mes-config-ms.commandes-last:10}")
    private int commandesLastDays;

    /**
     * Custom HealthIndicator to provide the health status of the microservice.
     */
    @Bean
    public HealthIndicator customHealthIndicator() {
        return () -> {
            // Simplified health logic (you can replace this with database check logic)
            boolean commandesPresentes = true;  // Simplified example: replace with actual check
            if (commandesPresentes) {
                return Health.up()
                        .withDetail("Message", "The service is operational and orders are available.")
                        .build();
            } else {
                return Health.down()
                        .withDetail("Message", "No orders available.")
                        .build();
            }
        };
    }

    /**
     * Custom endpoint to expose the current configuration (commandesLastDays).
     */
    @Endpoint(id = "commandesLastConfig")
    public static class CommandesLastEndpoint {

        private final int commandesLastDays;

        public CommandesLastEndpoint(int commandesLastDays) {
            this.commandesLastDays = commandesLastDays;
        }

        @ReadOperation
        public String commandesLastDays() {
            return "Displaying orders from the last " + commandesLastDays + " days.";
        }
    }

    /**
     * Bean to expose the custom endpoint.
     */
    @Bean
    public CommandesLastEndpoint commandesLastEndpoint() {
        return new CommandesLastEndpoint(commandesLastDays);
    }
}
