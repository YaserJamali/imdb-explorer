package com.globox.ali.repository;


import com.globox.ali.entities.VWBestGenresOfMoviesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface VWBestGenresOfMoviesRepositoryImpl
        extends IBaseImmutableRepository<VWBestGenresOfMoviesEntity, String> {


    List<VWBestGenresOfMoviesEntity> findAllByGenresLike(String genre, Pageable pageable);

}
