package com.violence.music.controller;

import com.violence.music.entity.Album;
import com.violence.music.service.AlbumService;
import com.violence.music.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private TrackService trackService;

    @GetMapping(name = "add")
    public String addGet(Model model) {
        model.addAttribute("tracks", trackService.getAll());
        return "addAlbum";
    }

    @PostMapping(name = "add")
    public @ResponseBody String addPost(Album album) {
        albumService.save(album);
        return "added";
    }

    @GetMapping(name = "getAll")
    public @ResponseBody String getAll() {
        return albumService.getAll().toString();
    }

    @GetMapping(name = "getByYear/{year}")
    public @ResponseBody String getByYear(@PathVariable(name = "year") Integer year) {
        return albumService.getAlbumsByYear(year).toString();
    }

    @GetMapping(name = "getByTrack/{track}")
    public @ResponseBody String getByTrack(@PathVariable(name = "track") String track) {
        return albumService.getAlbumByTrack(track).toString();
    }
}
