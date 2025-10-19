package com.example.dashborad_pipe.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Traversee")
public class Traversees {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_traversees", nullable = false)
    private Long id_traversees;
    private String name;
    private String entreprise;
    private Double pk;
    private Double pkf;
    private Date date_debut;
    private Date date_fin;

    private Double avancementphysique;
}
