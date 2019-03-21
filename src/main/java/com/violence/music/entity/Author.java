package com.violence.music.entity;

import java.util.Objects;

public class Author {
    private String PIB;

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(PIB, author.PIB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PIB);
    }

    @Override
    public String toString() {
        return "Author{" +
                "PIB='" + PIB + '\'' +
                '}';
    }
}
