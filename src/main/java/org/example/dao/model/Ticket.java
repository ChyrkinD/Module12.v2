package org.example.dao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    private Long id;
    @Column(name = "name",length = 200)
    private String name;
    @Column(name = "client_id",length = 200)
    private String clientId;
    @Column(name = "from_planet_id",length = 200)
    private String fromPlanetId;
    @Column(name = "to_planet_id",length = 200)
    private String toPlanetId;
}
