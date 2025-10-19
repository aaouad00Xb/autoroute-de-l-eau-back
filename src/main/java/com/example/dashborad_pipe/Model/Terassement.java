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
public class Terassement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_ter", nullable = false)
    private Long id_Ter;
    private String article;


    private Date date;
    private Date inputDate;
    private Date validation1;
    private Date validation2;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prevu_terrassement", referencedColumnName = "id_pre_ter")
    private Prevu_Terrassement prevu_terrassement;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reel_terrassement", referencedColumnName = "id_reel_ter")
    private Reel_Terrassement reel_terrassement;

}
