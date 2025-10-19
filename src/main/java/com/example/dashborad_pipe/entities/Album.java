package com.example.dashborad_pipe.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id_album;
    private String name;
    private Boolean parent;
    @ElementCollection
    private List<String> images = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Album> subAlbums = new HashSet<>();
}
