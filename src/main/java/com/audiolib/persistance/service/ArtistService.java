package com.audiolib.persistance.service;

import java.util.List;

import com.audiolib.persistance.model.Artist;
import com.audiolib.persistance.repository.ArtistRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    ArtistRepo artistRepo;

    public Artist findArtistById(Long id) {
        return artistRepo.findArtistById(id);
    }

    public Iterable<Artist> findAll() {
        return artistRepo.findAll();
    }

    public List<Artist> findByName(String name) {
        return artistRepo.findByName(name);
    }
}
