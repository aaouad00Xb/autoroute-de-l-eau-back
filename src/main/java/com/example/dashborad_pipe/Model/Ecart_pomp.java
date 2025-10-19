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
public class Ecart_pomp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_ecart_pomp", nullable = false)
    private Long id_ecart_pomp;

    private Date commande_passée_le;
    private Double quantite_de_la_semanie;
    private Double avanc_fabrication_pomp;
    private Double avanc_fabrication_moteur;
    private Date depart_usine;
    private Date arrivee_port_Casa;
    private Date approvionnement_sur_chantier;
    private Date sortie_port_casa;
    private Date montage_equipement;
    private Date essais;
}
