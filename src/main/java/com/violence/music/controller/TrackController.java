package com.violence.music.controller;

import com.violence.music.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TrackController {
    @Autowired
    private TrackService trackService;

}
