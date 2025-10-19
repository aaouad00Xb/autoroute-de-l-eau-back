package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.entities.Actions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepo extends JpaRepository<Actions,Long> {
}
