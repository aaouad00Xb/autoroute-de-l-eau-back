package com.example.dashborad_pipe.entities;

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
public class Cables_electrique {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cables_electrique", nullable = false)
    private Long id_cables_electrique;
    private Double qt;
    private Date Approvisionnement_sur_chantier;
    private Date date_achevement;
    private Double date_demarrage;
    private Double date_actuelle;
    private Double date_fin_prevision;

}
