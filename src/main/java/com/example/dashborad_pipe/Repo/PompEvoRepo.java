package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.Model.Electriquevolution;
import com.example.dashborad_pipe.Model.PompEvolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PompEvoRepo extends JpaRepository<PompEvolution,Long> {
    @Query(value = "select * from pomp_evolution where validation2 in(select max(validation2) from pomp_evolution)",nativeQuery = true)
    PompEvolution getValidate();
}
