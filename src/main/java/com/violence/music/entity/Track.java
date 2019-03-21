package com.violence.music.entity;

import java.util.Objects;
import java.util.Set;

public class Track {
    private Integer year;
    private String name;
    private Album album;
    private Set<Author> authors;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(year, track.year) &&
                Objects.equals(name, track.name) &&
                Objects.equals(album, track.album) &&
                Objects.equals(authors, track.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, name, album, authors);
    }

    @Override
    public String toString() {
        return "Track{" +
                "year=" + year +
                ", name='" + name + '\'' +
                ", album=" + album +
                ", authors=" + authors +
                '}';
    }
}
