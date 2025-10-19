package com.example.dashborad_pipe.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HeaderTuyoux {
    private Double depart_usine;
    private Double arrivee_port_Casa;
    private Double Approvionnement_sur_chantier_et_bardage;
    private Double Travaux_acheve;
}
