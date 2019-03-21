package com.violence.music.service;

import com.violence.music.entity.Album;
import com.violence.music.entity.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class AlbumServiceImplTest {
    private Album album;

    private AlbumService albumService = new AlbumServiceImpl();

    @Before
    public void init() {
        album = new Album();
        album.setName("OneMoreLight");
        album.setType("LP");
        album.setYear(2017);
        Set<Track> tracks = new HashSet<>();
        Track track = new Track();
        track.setName("OneMoreLight");
        track.setYear(2017);
        tracks.add(track);
        Track track2 = new Track();
        track.setName("BattleSymphony");
        track.setYear(2017);
        tracks.add(track2);
        album.setTracks(tracks);
    }

    @Test
    public void saveShouldReturnThisObjIfSaved() {
        Assert.assertEquals(album, albumService.save(album));
    }

    @Test
    public void saveShouldReturnNull() {
        albumService.save(album);
        Assert.assertNull(albumService.save(album));
    }

    @Test
    public void getAlbumByTrackShouldThrowException() {
        try {
            albumService.getAlbumByTrack("OneMoreLight");
            Assert.fail();
        } catch (NoSuchElementException e) {
            Assert.assertNotNull(e);
        }
    }
}