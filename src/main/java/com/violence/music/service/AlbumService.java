package com.violence.music.service;

import com.violence.music.entity.Album;

import java.util.List;

public interface AlbumService extends BaseMethods<Album> {
    List<Album> getAlbumsByYear(Integer year);
    Album getAlbumByTrack(String trackName);
}
