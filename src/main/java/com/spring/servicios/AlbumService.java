package com.spring.servicios;

import com.spring.dao.AlbumDaoImpl;
import com.spring.entidad.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumService {
    @Autowired
    AlbumDaoImpl albumDao;

    //@GetMapping("/listar")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    List<Album> findAll() {
        return albumDao.findAll();
    }

    @PostMapping("/insertar")
    Album save(@RequestBody Album Album) {
        return albumDao.save(Album);
    }


}
