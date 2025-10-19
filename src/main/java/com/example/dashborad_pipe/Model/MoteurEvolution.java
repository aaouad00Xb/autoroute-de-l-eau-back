package com.example.dashborad_pipe.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class MoteurEvolution {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date date;
    private Date validation1;
    private Date validation2;
    private Date inputDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prevu_moteur", referencedColumnName = "id_prevu_moteur")
    private Prevu_moteur prevu_moteur;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reel_pomp", referencedColumnName = "id_reel_moteur")
    private Reel_moteur reel_moteur;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Discussion> discussionList = new ArrayList<>();

}
