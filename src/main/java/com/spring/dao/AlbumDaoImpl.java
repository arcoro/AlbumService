package com.spring.dao;

import com.spring.entidad.Album;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class AlbumDaoImpl implements AlbumDao {

    private final String LISTAR="SELECT * FROM ALBUM";
    private final String insert = "INSERT INTO ALBUM (singerId,title,releaseDate) values (?,?,?)";

    private final JdbcTemplate jdbcTemplate;

    public AlbumDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Album> findAll() {
        return jdbcTemplate.query(LISTAR,new AlbumMapper());
    }

    @Override
    public Album findById(Long id) {
        return null;
    }

    @Override
    public Album save(Album album) {
        Object[] datos = new Object[] {album.getSingerId(), album.getTitle(),album.getReleaseDate()};
        int[] tipos = new int[]{Types.INTEGER, Types.VARCHAR, Types.DATE};
        int registro = jdbcTemplate.update(insert,datos,tipos);
        return album;
    }

    @Override
    public Album update(Album album) {
        return null;
    }

    @Override
    public Integer delete(Album album) {
        return null;
    }
}

class AlbumMapper implements RowMapper<Album> {

    @Override
    public Album mapRow (ResultSet rs, int rowNum) throws SQLException {
        Album album = new Album();
        album.setId(rs.getLong("id"));
        album.setSingerId(rs.getLong("singerId"));
        album.setTitle(rs.getString("title"));
        album.setReleaseDate(rs.getDate("releaseDate"));
        album.setVersion(rs.getInt("version"));
        return album;
    }
}
