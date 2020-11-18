package com.audiolib.persistance.service;

import java.util.List;

import com.audiolib.persistance.model.Artist;
import com.audiolib.persistance.repository.ArtistRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepo artistRepo;

    public Artist findArtistById(Long id) {
        return artistRepo.findArtistById(id);
    }

    public Page<Artist> findByNameIgnoreCase(String name, Pageable page) {
        return artistRepo.findByNameIgnoreCase(name, page);
    }

    public List<Artist> findByNameIgnoreCase(String name) {
        return artistRepo.findByNameIgnoreCase(name);
    }

    public Page<Artist> findAll(Pageable page) {
        return artistRepo.findAll(page);
    }

    public Artist create(Artist artist) {
        if (!artistRepo.findByNameIgnoreCase(artist.getName()).isEmpty()) {
            return null;
        }
        return artistRepo.save(artist);
    }

    public Artist update(Long id, Artist artist) {
        Artist toModify = artistRepo.findArtistById(id);
        if (toModify == null)
            return toModify;
        toModify.setName(artist.getName());
        toModify.setAlbums(artist.getAlbums());
        return artistRepo.save(toModify);
    }

    public void delete(Long id) {
        artistRepo.delete(artistRepo.findArtistById(id));
    }
}
