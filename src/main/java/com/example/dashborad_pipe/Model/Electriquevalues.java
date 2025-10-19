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
public class Electriquevalues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double  sortie_usine;
    private Double  livree_au_port;
    private Double  pose_sur_site;
    private Double  travaux_acheve;
    private Double Execution;
    private Double avancement_ph;
}
