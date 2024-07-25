package org.example;

import org.example.config.HibernateUtil;
import org.example.dao.model.Client;
import org.example.dao.model.Planet;
import org.example.servise.ClientCrudService;
import org.example.servise.PlanetCrudService;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5437/hibernate-h-w", "postgres", "password")
                .load();
        flyway.migrate();

        ClientCrudService clientCrudService = new ClientCrudService();

        Client client = new Client();
        client.setName("Tamara");
        clientCrudService.saveClient(client);
        System.out.println(client);

        Client findById = clientCrudService.findClientById(client.getId());
        System.out.println(findById);

        client.setName("Dima");
        clientCrudService.updateClient(client);

        clientCrudService.deleteClient(client);

        System.out.println("_".repeat(150));

        PlanetCrudService planetCrudService = new PlanetCrudService();

        Planet planet = new Planet();
        planet.setId("DIM");
        planet.setName("DIMA");
        planetCrudService.save(planet);
        System.out.println(planet);

        Planet findByIdPlanet = planetCrudService.getPlanetById(1L);
        System.out.println(findByIdPlanet);

        planet.setName("OLGA?");
        planetCrudService.update(planet);

        planetCrudService.delete(planet);

        HibernateUtil.getInstance().close();
    }
}