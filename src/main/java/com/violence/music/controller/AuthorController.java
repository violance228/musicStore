package com.violence.music.controller;

import com.violence.music.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;


}
