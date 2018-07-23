package com.spring;


import com.spring.dao.AlbumDao;
import com.spring.dao.AlbumDaoImpl;
import com.spring.entidad.Album;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.GregorianCalendar;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
        AlbumDao albumDao = context.getBean(AlbumDaoImpl.class);
      /*
      Album album = new Album();
        album.setTitle("From The Cradle");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1994, 8, 13)).getTime().getTime()));
        albumDao.save(album);

        Album album1 = new Album();
        album1.setTitle("The Search For Everything");
        album1.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(2017, 0, 20)).getTime().getTime()));
        albumDao.save(album1);

        Album album2 = new Album();
        album2.setTitle("Battle Studies");
        album2.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(2009, 10, 17)).getTime().getTime()));
        albumDao.save(album2);
        */
      List<Album> albums=albumDao.findAll();
      System.out.println(albums);
    }


}
