package com.violence.music.service;

import com.violence.music.entity.Album;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private static List<Album> albumList = new ArrayList<>();

    @Override
    public Album save(Album album) {
        Album result = null;
        if (albumList.stream().noneMatch(album1 -> album1.equals(album))) {
            albumList.add(album);
            result = albumList.get(albumList.size()-1);
        }
        return result;
    }

    @Override
    public List<Album> getAll() {
        return albumList;
    }

    @Override
    public Album findByName(String name) throws NoSuchElementException {
        return albumList.stream().filter(album -> album.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<Album> getAlbumsByYear(Integer year) {
        return albumList.stream().filter(album -> album.getYear().equals(year)).collect(Collectors.toList());
    }

    @Override
    public Album getAlbumByTrack(String trackName) throws NoSuchElementException {
        return albumList
                .stream().filter(album ->
                        album.getTracks().stream().anyMatch(track -> track.getName().equals(trackName)))
                .findFirst().get();
    }
}
