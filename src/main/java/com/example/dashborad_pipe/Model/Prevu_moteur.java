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
public class Prevu_moteur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_prevu_moteur", nullable = false)
    private Long id_prevu_moteur;
    private Double avacementPhysique;
    private Double avacementtemp;

    private Double qmAvacementPhysique;
    private Double qmAvacementtemp;


}
