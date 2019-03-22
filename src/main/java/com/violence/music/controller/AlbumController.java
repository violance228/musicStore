package com.violence.music.controller;

import com.google.gson.Gson;
import com.violence.music.entity.Album;
import com.violence.music.service.AlbumService;
import com.violence.music.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private TrackService trackService;
    private Gson gson = new Gson();

    @PostMapping(name = "/add")
    public String addPost(@RequestBody String json) {
        albumService.save(gson.fromJson(json, Album.class));
        return "added";
    }

    @GetMapping("getAll")
    public String getAll() {
        return gson.toJson(albumService.getAll().toString());
    }

    @GetMapping("/getByYear/{year}")
    public String getByYear(@PathVariable Integer year) {
        return gson.toJson(albumService.getAlbumsByYear(year).toString());
    }

    @GetMapping("getByTrack/{track}")
    public String getByTrack(@PathVariable String track) {
        return gson.toJson(albumService.getAlbumByTrack(track).toString());
    }
}
