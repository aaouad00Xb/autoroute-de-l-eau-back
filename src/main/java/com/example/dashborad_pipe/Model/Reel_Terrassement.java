package com.example.dashborad_pipe.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Reel_Terrassement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_reel_ter", nullable = false)
    private Long id_reel_ter;
    private Double ouverture_de_la_plteforme;
    private Double abattage_arbres;
    private Double pistes_acces ;
    private Double terrassement_cumules ;
    private boolean actif;
    private String commentaire;




}
