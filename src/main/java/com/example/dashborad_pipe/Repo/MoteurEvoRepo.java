package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.Model.MoteurEvolution;
import com.example.dashborad_pipe.Model.PompEvolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MoteurEvoRepo  extends JpaRepository<MoteurEvolution,Long> {

    @Query(value = "select * from moteur_evolution where validation2 in(select max(validation2) from pomp_evolution)",nativeQuery = true)
    MoteurEvolution getValidate();
}
