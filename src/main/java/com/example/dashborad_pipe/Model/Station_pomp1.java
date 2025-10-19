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
public class Station_pomp1 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pomp", nullable = false)
    private Long id_pomp;
    private Date inputDate;
    private String name;
    private Date validation1;
    private Date validation2;
    private Date commencement;
    private Date achevement;
    private Date date_demarrage;
    private Date date_actuelle;
    private Date date_fin_prevision;
    private Double avance_delais;
    private Double avance_physique;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "prevu_pomp", referencedColumnName = "id_prevu_pomp")
//    private Prevu_pomp prevu_pomp;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "reel_pomp", referencedColumnName = "id_reel_pomp")
//    private Reel_pomp reel_pomp;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ecart_pomp", referencedColumnName = "id_ecart_pomp")
//    private Ecart_pomp ecart_pomp;

}
