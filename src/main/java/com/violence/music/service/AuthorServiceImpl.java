package com.violence.music.service;

import com.violence.music.entity.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static List<Author> authorList = new ArrayList<>();

    @Override
    public Author save(Author author) {
        Author result = null;
        if (authorList.stream().noneMatch(author1 -> author1.equals(author))) {
            authorList.add(author);
            result = authorList.stream().filter(author1 -> author1.equals(author)).findFirst().get();
        }
        return result;
    }

    @Override
    public List<Author> getAll() {
        return authorList;
    }

    @Override
    public Author findByName(String name) {
        return authorList.stream().filter(author1 -> author1.getPIB().equals(name)).findFirst().get();
    }
}
