package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.Model.Tuyaux;
import com.example.dashborad_pipe.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TuyouxRepo extends JpaRepository<Tuyaux,Long> {


    @Query(value = "select * from tuyaux where validation2 in(select max(validation2) from tuyaux)",nativeQuery = true)
    Tuyaux getValidate();


    @Query(value = "select * from tuyaux order by date",nativeQuery = true)
    List<Tuyaux> orderBydate();

    @Query(value = "select * from tuyaux t where date = :date",nativeQuery = true)
    Tuyaux getbyDate(@Param("date") Date date);
}
