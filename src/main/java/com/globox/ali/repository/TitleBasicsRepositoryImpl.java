package com.globox.ali.repository;

import com.globox.ali.entities.TitleBasicsEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleBasicsRepositoryImpl extends BaseRepository<TitleBasicsEntity, String> {

//    @Query("SELECT t FROM TitleBasicsEntity t " +
//            "JOIN TitleCrewEntity c ON t.tconst = c.tconst " +
//            "JOIN NameBasicsEntity n ON n.nconst MEMBER OF c.directors AND n.nconst MEMBER OF c.writers " +
//            "WHERE n.deathYear IS NULL")
//    List<TitleBasicsEntity> findTitlesWithSameDirectorAndWriterAlive();

//    @Override
//    @Query("SELECT t FROM TitleBasicsEntity t " +
//            "JOIN TitleCrewEntity c ON t.tconst = c.tconst " +
//            "JOIN NameBasicsEntity n ON n.nconst MEMBER OF c.directors " +
//            "JOIN NameBasicsEntity n2 ON n2.nconst MEMBER OF c.writers " +
//            "WHERE n.nconst = n2.nconst AND n.deathYear IS NULL")
//    List<TitleBasicsEntity> findAll();

}

