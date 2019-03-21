package com.violence.music.service;

import com.violence.music.entity.Track;

import java.util.List;

public interface TrackService extends BaseMethods<Track> {
    List<Track> getTracksByAlbum(String albumName);
    List<Track> getTracksByAuthor(String authorName);
}
