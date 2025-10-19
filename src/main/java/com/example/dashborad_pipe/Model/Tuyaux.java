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
public class Tuyaux {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_tuyaux", nullable = false)

    private Long id_tuyaux;
    private Date date;
    private Date inputDate;
    private Date validation1;
    private Date validation2;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prevu_tuyaux", referencedColumnName = "id_prevu_tuyaux")
    private Prevu_tuyaux prevu_tuyaux;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reel_tuyaux", referencedColumnName = "id_reel_tuyaux")
    private Reel_tuyaux reel_tuyaux;


    @OneToMany(cascade = {CascadeType.ALL})
    private List<Discussion> discussionList = new ArrayList<>();
}
