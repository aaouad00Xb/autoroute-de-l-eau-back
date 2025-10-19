package com.example.dashborad_pipe.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(columnDefinition="text")
    private String actioner;
    @Column(columnDefinition="text")
    private String ipAdress;
    @Column(columnDefinition="text")
    private String cibledData;
    @Column(columnDefinition="text")
    private String befor;
    @Column(columnDefinition="text")
    private String after;
    private Date time;
}
