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
public class Station_pomp2 {
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

}
