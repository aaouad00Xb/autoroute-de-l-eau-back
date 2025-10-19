package com.example.dashborad_pipe.Repo;

import com.example.dashborad_pipe.entities.Album;
import com.example.dashborad_pipe.entities.Habilitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<Album,Long> {
}
