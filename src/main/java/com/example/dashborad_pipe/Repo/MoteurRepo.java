package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.Model.Moteur;
import com.example.dashborad_pipe.Model.MoteurEvolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoteurRepo extends JpaRepository<Moteur,Long> {
}
