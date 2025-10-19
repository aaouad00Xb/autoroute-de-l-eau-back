package com.example.dashborad_pipe.entities;


import com.example.dashborad_pipe.Model.Discussion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "phases")
public class Phase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false, length = 3000)
    private String name;
    private String style;
    private Double avancement;
    private Date dateDepart;
    private Date dateDepartR;
    private String objet;
    private Date delais;
    private Double longeur;
    private String entreprise;
    @Column(name = "pkdebut", nullable = false)
    private Double pkdebut;
    @Column(name = "pkfin", nullable = false)
    private Double pkfin;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Avancement> avancements = new ArrayList<>();
}