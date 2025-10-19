package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.entities.Avancement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AvancementRepo extends JpaRepository<Avancement,Long>{
    @Modifying
    @Transactional
    @Query(value = "delete from phases_avancements where avancements_id_av = :id",nativeQuery = true)
    void suprimer(@Param("id") Long id);
    @Modifying
    @Transactional
    @Query(value = "delete from avancement where id_av = :id",nativeQuery = true)
    void suprimer2(@Param("id") Long id);

}
