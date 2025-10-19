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
public class Electrique {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_ele", nullable = false)
    private Long id_ele;
    private String name;
    private Date validation1;
    private Date validation2;

    private Date appr_chant;
    private Date achevement;
    private Date demarrage;
    private Integer qtt;
    private Date dateActuel;
    private Date dateFinPrev;

//    @OneToOne(cascade = CascadeType.ALL)
//    private ReelPElectrique reelPElectrique;
//    @OneToOne(cascade = CascadeType.ALL)
//    private PrevuPElectrique prevuPElectrique;




}
