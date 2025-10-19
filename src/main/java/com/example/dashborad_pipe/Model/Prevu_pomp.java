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
public class Prevu_pomp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_prevu_pomp", nullable = false)
    private Long id_prevu_pomp;
    private Double avacementPhysique;
    private Double avacementtemp;

    private Double qmAvacementPhysique;
    private Double qmAvacementtemp;



}
