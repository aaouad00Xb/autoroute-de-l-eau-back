package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.Model.Terassement;
import com.example.dashborad_pipe.Model.Tuyaux;
import com.example.dashborad_pipe.entities.Taskphase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TerrassementRepo extends JpaRepository<Terassement,Long> {

    @Query(value = "select * from terassement where input_date in(select max(input_date) from terassement)",nativeQuery = true)
    Terassement getValidate();

        @Query(value="select * from terassement order by date",nativeQuery = true)
     List<Terassement> gettingAllTerrassement();

}
