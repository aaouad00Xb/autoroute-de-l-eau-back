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
public class Reel_Traversees {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_reel_trav", nullable = false)
    private Long id_reel_trav;
    private Date date_demarrage;
    private Date date_actuelle;
    private Date date_fin_prevision;

    private Double avance_delais;
    private Double avance_physique;

}
