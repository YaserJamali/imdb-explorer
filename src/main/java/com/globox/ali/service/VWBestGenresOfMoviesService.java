package com.globox.ali.service;

import com.globox.ali.dto.VWBestGenresOfMoviesDto;
import com.globox.ali.entities.VWBestGenresOfMoviesEntity;
import com.globox.ali.exceptions.NoSuchGenreExistsException;
import com.globox.ali.repository.VWBestGenresOfMoviesRepositoryImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VWBestGenresOfMoviesService
        extends BaseImmutableAbstractService<VWBestGenresOfMoviesEntity, VWBestGenresOfMoviesDto, String, VWBestGenresOfMoviesRepositoryImpl> {


    @Cacheable(value = "moviesByGenre")
    public List<VWBestGenresOfMoviesDto> findAllByGenres(String genre, Integer pageNumber, Integer pageSize) {
        List<VWBestGenresOfMoviesEntity> entityList = repository.findAllByGenresLike(
                genre, Pageable.ofSize(pageSize).withPage(pageNumber));
        if (entityList.isEmpty()) {
            throw new NoSuchGenreExistsException(genre);
        }
        return converter.convertEntity(entityList);
    }
}