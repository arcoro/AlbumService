package com.spring.dao;

import com.spring.entidad.Album;

import java.util.List;

public interface AlbumDao{
    List<Album> findAll();
    Album findById(Long id);
    Album save(Album Album);
    Album update(Album Album);
    Integer delete(Album Album);
}
