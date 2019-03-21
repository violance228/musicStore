package com.violence.music.service;

import java.util.List;

public interface BaseMethods<T> {
    T save(T t);
    List<T> getAll();
    T findByName(String name);
}
