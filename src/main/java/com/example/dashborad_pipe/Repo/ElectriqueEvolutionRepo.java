package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.Model.Electriquevolution;
import com.example.dashborad_pipe.Model.Tuyaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ElectriqueEvolutionRepo extends JpaRepository<Electriquevolution,Long> {


    @Query(value = "select * from electriquevolution where validation2 in(select max(validation2) from electriquevolution)",nativeQuery = true)
    Electriquevolution getValidate();

}
