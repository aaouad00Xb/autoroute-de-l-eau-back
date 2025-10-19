package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.entities.Phase;
import com.example.dashborad_pipe.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface PhaseRepository extends JpaRepository<Phase,Integer> {

    Phase findPhaseById(Integer id);
    @Query(value="select * from getprojectPhases()" , nativeQuery = true)
    List<Map<String,?>> getprojectPhases();


    @Query(value="select a.entreprise,a.pk_debut,a.pk_fin,ST_AsGeoJSON(ST_LineSubstring(ST_LineMerge(p.geom), a.pk_debut/65.750,a.pk_fin/65.750)) from projet p,avancement a" , nativeQuery = true)
    List<Map<String,?>> getavancements();


    @Query(value="select * from spliteF(:id,:pourcent)" , nativeQuery = true)
    Integer spliteF(@Param("id") Integer id,@Param("pourcent") Double pourcent);

}
