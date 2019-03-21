package com.violence.music.service;

import com.violence.music.entity.Track;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackServiceImpl implements TrackService {
    private static List<Track> trackList = new ArrayList<>();

    @Override
    public Track save(Track track) {
        Track result = null;
        if (trackList.stream().noneMatch(track1 -> track1.equals(track))) {
            trackList.add(track);
            result = trackList.stream().filter(track1 -> track1.equals(track)).findFirst().get();
        }
        return result;
    }

    @Override
    public List<Track> getAll() {
        return trackList;
    }

    @Override
    public Track findByName(String name) {
        return trackList.stream().filter(track -> track.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<Track> getTracksByAlbum(String albumName) {
        return trackList.stream().filter(track -> track.getAlbum().getName().equals(albumName)).collect(Collectors.toList());
    }

    @Override
    public List<Track> getTracksByAuthor(String authorName) {
        return trackList
                .stream().filter(track -> track.getAuthors()
                        .stream().anyMatch(author -> author.getPIB().equals(authorName)))
                .collect(Collectors.toList());
    }
}
