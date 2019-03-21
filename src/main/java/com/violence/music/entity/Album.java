package com.violence.music.entity;

import java.util.Objects;
import java.util.Set;

public class Album {
    private String type;
    private String name;
    private Integer year;
    private Set<Track> tracks;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(type, album.type) &&
                Objects.equals(name, album.name) &&
                Objects.equals(year, album.year) &&
                Objects.equals(tracks, album.tracks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, year, tracks);
    }

    @Override
    public String toString() {
        return "Album{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", tracks=" + tracks +
                '}';
    }
}
