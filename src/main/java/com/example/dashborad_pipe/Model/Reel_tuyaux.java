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
public class Reel_tuyaux {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_reel_tuyaux", nullable = false)
    private Long id_reel_tuyaux;

    private Date depart_usine;
    private Double qt_depart_usine;
    private Double qm_depart_usine;

    private Date arrivee_port_Casa;
    private Double qt_arrivee_port_Casa;
    private Double qm_arrivee_port_Casa;

    private Date sortie_port_Casa;
    private Double qt_sortie_port_Casa;
    private Double qm_sortie_port_Casa;

    private Date Approvionnement_sur_chantier_et_bardage;
    private Double qt_Approvionnement_sur_chantier_et_bardage;
    private Double qm_Approvionnement_sur_chantier_et_bardage;

    private Date pose_Soudure_et_controle;
    private Double qt_pose_Soudure_et_controle;
    private Double qm_pose_Soudure_et_controle;


    private boolean actif;
    private String commentaire;

}
