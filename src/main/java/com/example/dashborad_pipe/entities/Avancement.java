package com.example.dashborad_pipe.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Avancement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_av", nullable = false)
    private Long id_av;
    private Double pk_debut;
    private Double pk_fin;
    private Double avancement; // Progress percentage (0-100)

}
